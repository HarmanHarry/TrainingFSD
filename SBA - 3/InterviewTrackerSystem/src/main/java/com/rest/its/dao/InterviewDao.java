package com.rest.its.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rest.its.entity.Interview;

@Repository
public interface InterviewDao extends JpaRepository<Interview, Integer>{
	
	@Query("SELECT i FROM Interview i WHERE i.interviewId =:interviewId")
	List<Interview> findAllById(Integer interviewId);
	
	@Query("SELECT i FROM Interview i WHERE i.interviewName =:interviewName or i.interviewerName=:interviewerName")
	List<Interview> findByName(String interviewName, String interviewerName);
}
