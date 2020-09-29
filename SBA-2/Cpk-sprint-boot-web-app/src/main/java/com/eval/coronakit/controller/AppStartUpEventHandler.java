package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Users;



@Component
public class AppStartUpEventHandler {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired	
	private PasswordEncoder pEnc;
	
	
	@EventListener
	public void onAppStartup(ApplicationReadyEvent event) {
		if(!userRepo.existsByUsername("Admin")) {
			userRepo.save(new Users("Admin", "admin",pEnc.encode("admin"),true,"superuser@admin.com","9999999999" , "ADMIN"));
		}		
		if(!userRepo.existsByUsername("First")) {
			userRepo.save(new Users("First", "abc",pEnc.encode("abc"),true,"First@user.com","1000000001" , "USER"));
		}
		if(!userRepo.existsByUsername("Second")) {
			userRepo.save(new Users("Second", "abc",pEnc.encode("abc"),true,"Second@user.com","1000000002" , "USER"));
		}
	}
}