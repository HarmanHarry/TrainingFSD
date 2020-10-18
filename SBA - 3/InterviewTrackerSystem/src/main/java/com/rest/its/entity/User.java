package com.rest.its.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements Serializable, Comparable<User>{

	@Id
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attendees")
	private Set<Interview> interviews = new HashSet<>();
	
	public User() {
		//left unimplemented
	}
	
	public User(Integer userId, String firstName, String lastName, String email, String mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public User(Integer userId, String firstName, String lastName, String email, String mobile,
			Set<Interview> interviews) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.interviews = interviews;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public void delInterview() {
		for (Interview interview : new HashSet<>(this.interviews)) {
			this.interviews.remove(interview);
			interview.getAttendees().remove(this);
		}
	}

	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
