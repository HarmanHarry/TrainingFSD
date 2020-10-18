package com.rest.its.service;

import java.util.Set;

import com.rest.its.exception.ITSException;
import com.rest.its.model.AttendeeModel;
import com.rest.its.model.InterviewModel;
import com.rest.its.model.UserModel;


public interface InterviewService {

	InterviewModel addInterview(InterviewModel interview) throws ITSException;
	
	InterviewModel getInterview(Integer interviewId);
	
	boolean deleteInterview(Integer interviewId) throws ITSException;
	
	Set<InterviewModel> getAllInterviews();
	
	Integer getInterviewsCount();
	
	InterviewModel updateInterviewStatus(Integer interviewid, String status) throws ITSException;
	
	Set<InterviewModel> searchInterviewByName(String interviewName, String interviewerName);
	
	void addAttendee(AttendeeModel attendee) throws ITSException;
	
	Set<UserModel> showAttendees(Integer interviewId) throws ITSException;
	
}
