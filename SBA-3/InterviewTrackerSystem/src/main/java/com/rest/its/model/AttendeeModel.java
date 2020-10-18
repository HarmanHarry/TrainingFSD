package com.rest.its.model;

import javax.validation.constraints.NotNull;


public class AttendeeModel {

	@NotNull(message = "InterviewId cannot be null or blank.")
	private int interviewId;
	
	@NotNull(message = "UserId cannot be null or blank.")
	private int userId;
	
	public AttendeeModel(int interviewId, int userId) {
		super();
		this.interviewId = interviewId;
		this.userId = userId;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


}
