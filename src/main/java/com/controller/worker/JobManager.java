package com.controller.worker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class JobManager {
	private static boolean isCalled = false;
	public static ArrayDeque<Job> fetchJobs() {
		List<Job> jobs = new ArrayList<>();
		Job job = null;
		for(int i = 1; i <= 15; i++) {
			job = new Job();
			job.setId(i);
			jobs.add(job);
		}
		
		// Fetch records from db
		// find clean-able records
		// add them to the jobs list
		ArrayDeque<Job> deque = new ArrayDeque<>();
		deque.addAll(jobs);
		return deque;
	}
	
	public static JobResult triggerCleanUp(Job job) {
		JobResult result = new JobResult(job.getId(), job, true);
		try {
			System.out.println("Cleaning job#: " + job.getId());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		if (job.getId() == 10) {
			if (!isCalled) {
				isCalled = true;
				System.err.println("\nCleaning failed: " + job.getId());
				result = new JobResult(job.getId(), job, false);
			}
		}
		return result;
	}
}
