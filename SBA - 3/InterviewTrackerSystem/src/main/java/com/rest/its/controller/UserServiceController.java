package com.rest.its.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.its.exception.ITSException;
import com.rest.its.model.UserModel;
import com.rest.its.service.UserService;


@RestController
@RequestMapping("/user")
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/newUser")
	public ResponseEntity<UserModel> addNewUser(@RequestBody @Valid UserModel user,BindingResult result) throws ITSException{
		if(result.hasErrors()) {
			throw new ITSException(GlobalExceptionController.errorMsg(result));
		}
		
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id")int userId){
		ResponseEntity<Object> response=null;		
		UserModel user = userService.getUser(userId);
		
		if(user==null)
			response =new ResponseEntity<>("User not found with id - "+userId,HttpStatus.NOT_FOUND);
			else
				response =new ResponseEntity<>(user,HttpStatus.OK);
				
		return response;
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id")int userId) throws ITSException{
		userService.deleteUser(userId);		
		return new ResponseEntity<>("User with id-'"+userId+"' deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		return new ResponseEntity<List<UserModel>>(userService.getAllUsers(),HttpStatus.OK);
	}
}
