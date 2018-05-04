package com.controller.worker;

public class JobResult {
	private Integer jobId;
	private Job job;
	private Boolean result;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public JobResult(Integer jobId, Job job, Boolean result) {
		super();
		this.jobId = jobId;
		this.job = job;
		this.result = result;
	}

	public JobResult() {
		super();
	}
}
