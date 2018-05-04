package com.controller.worker;

import java.util.Calendar;

import javax.print.attribute.standard.JobState;

public class Job {
	private Integer id;
	private String developerId;
	private String applications;
	private String tenantId;
	private Calendar offboardingDate;
	private JobState state;
	private Calendar processingStartTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getApplications() {
		return applications;
	}

	public void setApplications(String applications) {
		this.applications = applications;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Calendar getOffboardingDate() {
		return offboardingDate;
	}

	public void setOffboardingDate(Calendar offboardingDate) {
		this.offboardingDate = offboardingDate;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public Calendar getProcessingStartTime() {
		return processingStartTime;
	}

	public void setProcessingStartTime(Calendar processingStartTime) {
		this.processingStartTime = processingStartTime;
	}
}
