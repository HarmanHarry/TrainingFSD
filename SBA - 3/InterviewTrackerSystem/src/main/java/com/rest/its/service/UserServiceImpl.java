package com.rest.its.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.its.dao.UserDao;
import com.rest.its.entity.User;
import com.rest.its.exception.ITSException;
import com.rest.its.model.UserModel;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepo;
	
	private User toEntity(UserModel model) {
		return new User(model.getUserId(), model.getFirstName(), model.getLastName(),model.getEmail(), model.getMobile());
	}
	
	private UserModel toModel(User entity) {
		return new UserModel(entity.getUserId(),entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getMobile());
	}

	
	@Override
	@Transactional
	public UserModel addUser(UserModel user) throws ITSException {
		
        if(user!=null) {
            if(userRepo.existsById(user.getUserId())) {
                throw new ITSException("UserId already exist.. Please choose different one!");
            }
            
            user = toModel(userRepo.save(toEntity(user)));
        }
        
        return user;
	}

	@Override
	@Transactional
	public boolean deleteUser(int userId) throws ITSException {
		
		if(!userRepo.existsById(userId)) {
			throw new ITSException("User not found or already deleted!");
		}
		
		User user = userRepo.findById(userId).orElse(null);
		user.delInterview();
		userRepo.flush();
		userRepo.delete(user);
		return true;
	}

	@Override
	public UserModel getUser(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        return user!=null?toModel(user):null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserModel> userModels=null;
		List<User> users= userRepo.findAll();
		
		if(users!=null && !users.isEmpty()) {
			userModels = users.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		
		return userModels;
	}

}
