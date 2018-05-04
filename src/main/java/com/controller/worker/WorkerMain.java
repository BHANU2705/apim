package com.controller.worker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkerMain {

	public List<Future<JobResult>> cleanUp(ArrayDeque<Job> jobQueue, Type type) {
		List<Future<JobResult>> results = null;
		ExecutorService executor = Executors.newFixedThreadPool(3);
		results = processJobQueue(jobQueue, results, executor);
		readResults(jobQueue, results);
		if (!jobQueue.isEmpty()) {
			System.out.println("Retrying");
			results = processJobQueue(jobQueue, results, executor);
		}
		executor.shutdown();
		System.out.println("Finished all jobs");
		return results;
	}

	private void readResults(ArrayDeque<Job> jobQueue, List<Future<JobResult>> results) {
		try {
			JobResult jobResult = null;
			for (Future<JobResult> result : results) {
				jobResult = result.get();
				if (!jobResult.getResult()) {
					jobQueue.add(jobResult.getJob());
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private List<Future<JobResult>> processJobQueue(ArrayDeque<Job> jobs, List<Future<JobResult>> results,
			ExecutorService executor) {
		Job currentJob = null;
		results = new ArrayList<>();
		while (!jobs.isEmpty()) {
			currentJob = jobs.pop();
			Future<JobResult> result = processUsingCallable(jobs, executor, currentJob);
			results.add(result);
		}
		return results;
	}

	private Future<JobResult> processUsingCallable(ArrayDeque<Job> jobs, ExecutorService executor, Job currentJob) {
		Callable<JobResult> worker = new WorkerThreadUsingCallable(currentJob);
		Future<JobResult> result = executor.submit(worker);
		return result;
	}

	/*private void processUsingRunnable(ExecutorService executor, Job currentJob) {
		Runnable worker = new WorkerThreadUsingRunnable(currentJob);
		executor.execute(worker);
	}*/
}
