package com.rest.its.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="interviews")
public class Interview implements Serializable,Comparable<Interview>{
	
	@Id
	private Integer interviewId;
	
	private String interviewerName;
	
	private String interviewName;
	
	private String usersSkills;
	
	private LocalTime time;

	private LocalDate date;
	
	private String interviewStatus;

	private String remarks;
	
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attendee", 
      joinColumns = @JoinColumn(name = "interviewId"), 
      inverseJoinColumns = @JoinColumn(name = "userId"))
	private Set<User> attendees = new HashSet<>();
	
    public Interview() {
		//left unimplemented
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

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
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


	public Set<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<User> attendees) {
		this.attendees = attendees;
	}

	public Interview(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks, Set<User> attendees) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendees =attendees;
	}

	public Interview(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks) {
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

	 
	    public void removeAttendees() {
	        for(User users : new HashSet<>(this.attendees)) {
	        	this.attendees.remove(users);
	        	users.getInterviews().remove(this);
	        }
	    }

	@Override
	public int compareTo(Interview o) {	
		return 0;
	}
}
