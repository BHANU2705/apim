package com.controller.worker;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WorkerListener implements ServletContextListener {

	public WorkerListener() {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String servlet = sce.getServletContext().getServletContextName();
		System.out.println(servlet + " destroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WorkerListener.contextInitialized()");
		final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		final Runnable beeper = new Runnable() {
			@Override
			public void run() {
				ArrayDeque<Job> jobs = JobManager.fetchJobs();
				WorkerMain workerMain = new WorkerMain();
				List<Future<JobResult>> results = workerMain.cleanUp(jobs, Type.CALLABLE);
			}
		};
		scheduler.scheduleAtFixedRate(beeper, 5, 100, TimeUnit.SECONDS);
	}

}
