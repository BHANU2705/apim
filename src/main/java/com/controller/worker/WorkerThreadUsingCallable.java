package com.controller.worker;

import java.util.concurrent.Callable;

public class WorkerThreadUsingCallable implements Callable<JobResult> {
	private Job job;

	public WorkerThreadUsingCallable(Job job) {
		this.job = job;
	}

	@Override
	public JobResult call() {
		System.out.println("\n-------------------------------------------------------------------------------------");
		System.out.println(Thread.currentThread().getName() + " Starting = " + job.getId());
		JobResult status = JobManager.triggerCleanUp(job);
		System.out.println(Thread.currentThread().getName() + " Ending = " + job.getId());
		System.out.println("-------------------------------------------------------------------------------------\n");
		return status;
	}
}
