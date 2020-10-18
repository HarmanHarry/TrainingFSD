package com.rest.its.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {
	
	@NotNull(message = "UserId cannot be null or blank.")
	private Integer userId;
	
	@NotBlank(message = "First Name cannot be null or blank.")
	@Size(min = 5, max = 30, message = "First Name should contain min 5 and max 30 characters.")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be null or blank.")
	@Size(min = 3, max = 25, message = "Last Name should contain min 3 and max 25 characters.")
	private String lastName;
	
	@NotBlank(message = "Email address cannot be null or blank.")
	@Email(message="Email address is not valid.")
	private String email;
	
	@NotEmpty(message = "Mobile Number cannot be null or empty.")
	@Pattern(regexp="(^$|[0-9]{10})", message="Mobile Number is not valid.")
	private String mobile;
		
	
	public UserModel(Integer userId,String firstName,String lastName,String email,String mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
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


}
