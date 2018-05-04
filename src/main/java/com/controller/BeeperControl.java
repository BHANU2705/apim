package com.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class BeeperControl {
	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("beep");
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 24, TimeUnit.HOURS);

		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, 300, TimeUnit.SECONDS);

	}
}
