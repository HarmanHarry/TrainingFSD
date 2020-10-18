package com.rest.its.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.its.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
}	
