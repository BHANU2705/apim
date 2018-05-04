package com.controller.worker;

public class WorkerThreadUsingRunnable implements Runnable {
	private Job job;

	public WorkerThreadUsingRunnable(Job job) {
		this.job = job;
	}

	@Override
	public void run() {
		System.out.println("\n-------------------------------------------------------------------------------------");
		System.out.println(Thread.currentThread().getName() + " Starting = " + job.getId());
		JobManager.triggerCleanUp(job);
		System.out.println(Thread.currentThread().getName() + " Ending = " + job.getId());
		System.out.println("-------------------------------------------------------------------------------------\n");
	}
}
