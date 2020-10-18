package com.rest.its.service;

import java.util.List;

import com.rest.its.exception.ITSException;
import com.rest.its.model.UserModel;


public interface UserService {

	UserModel addUser(UserModel user) throws ITSException;
	
	boolean deleteUser(int userId) throws ITSException;
	
	UserModel getUser(int userId);
	
	List<UserModel> getAllUsers();

}
