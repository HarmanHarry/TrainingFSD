package com.rest.its.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InterviewModel {
	@NotNull(message = "InterviewId cannot be null or blank.")
	private Integer interviewId;
	
	@NotBlank(message = "Interviewer cannot be null or blank.")
	@Size(min = 5, max = 30, message = "Interviewer Name should contain min 5 and max 30 characters")
	private String interviewerName;
	
	@NotBlank(message = "Interview Name cannot be null or blank.")
	@Size(min = 3, max = 30, message = "Interview Name should contain min 3 and max 30 characters")
	private String interviewName;
	
	@NotBlank(message = "Users Skills cannot be null or blank.")
	@Size(min = 5, max = 30, message = "Users Skills should contain min 5 and max 30 characters")
	private String usersSkills;
	
	@NotBlank(message = "Interview Status cannot be null or blank.")
	@Size(min = 5, max = 100, message = "Interview Status should contain min 5 and max 100 characters")
	private String interviewStatus;
	
	@NotBlank(message = "Remarks cannot be null or blank.")
	@Size(min = 5, max = 100, message = "Remarks should contain min 5 and max 100 characters")
	private String remarks;
	
	private LocalTime time;	
	
	private LocalDate date;
	
	@Valid
	private Set<UserModel> attendee;		
	
	public InterviewModel() {
		//left unimplemented
	}

	public InterviewModel(Integer interviewId, String interviewerName ,String interviewName, String usersSkills, LocalTime time, LocalDate date, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
	

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills, LocalTime time, LocalDate date, String interviewStatus, String remarks, Set<UserModel> attendees) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendee = attendees;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Set<UserModel> getAttendee() {
		return attendee;
	}
	
	public void setAttendee(Set<UserModel> attendees) {
		this.attendee = attendees;
	}


}
