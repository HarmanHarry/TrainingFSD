package com.rest.its.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.its.dao.InterviewDao;
import com.rest.its.dao.UserDao;
import com.rest.its.entity.Interview;
import com.rest.its.entity.User;
import com.rest.its.exception.ITSException;
import com.rest.its.model.AttendeeModel;
import com.rest.its.model.InterviewModel;
import com.rest.its.model.UserModel;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewDao interviewRepo;
	
	@Autowired
	private UserDao userRepo;

	private Interview toInterviewEntity(InterviewModel interviewModel) {
		if(interviewModel.getAttendee()==null)
			return new Interview(interviewModel.getInterviewId(), interviewModel.getInterviewerName(), interviewModel.getInterviewName(), interviewModel.getUsersSkills(), interviewModel.getTime(), interviewModel.getDate(), interviewModel.getInterviewStatus(), interviewModel.getRemarks());
		else
			return new Interview(interviewModel.getInterviewId(), interviewModel.getInterviewerName(), interviewModel.getInterviewName(), interviewModel.getUsersSkills(), interviewModel.getTime(), interviewModel.getDate(), interviewModel.getInterviewStatus(), interviewModel.getRemarks(),toUserEntities(interviewModel.getAttendee()));
	}
	
	private InterviewModel toInterviewModel(Interview interview) {		
		if(interview.getAttendees()==null)
			return new InterviewModel(interview.getInterviewId(), interview.getInterviewerName(), interview.getInterviewName(), interview.getUsersSkills(), interview.getTime(), interview.getDate(), interview.getInterviewStatus(), interview.getRemarks());
		else
			return new InterviewModel(interview.getInterviewId(), interview.getInterviewerName(), interview.getInterviewName(), interview.getUsersSkills(), interview.getTime(), interview.getDate(), interview.getInterviewStatus(), interview.getRemarks(), toUserModels(interview.getAttendees()));
	}
	
	private User toUserEntity(UserModel model) {
		return new User(model.getUserId(), model.getFirstName(), model.getLastName(),model.getEmail(), model.getMobile());
	}
	
	private Set<User> toUserEntities(Set<UserModel> userModels) {
		Set<User> entities=null;
		entities = userModels.stream().map(e -> toUserEntity(e)).collect(Collectors.toSet());
		return entities;
	}
	
	private UserModel toUserModel(User entity) {
		return new UserModel(entity.getUserId(), entity.getFirstName(), entity.getLastName(),entity.getEmail(), entity.getMobile());
	}
	
	private Set<UserModel> toUserModels(Set<User> userEntities) {
		Set<UserModel> models=null;
		models = userEntities.stream().map(e -> toUserModel(e)).collect(Collectors.toSet());
		return models;
	}
	
	
	
	
	@Override
	@Transactional
	public InterviewModel addInterview(InterviewModel interview) throws ITSException {
        if(interview!=null) {
            if(interviewRepo.existsById(interview.getInterviewId())) {
                throw new ITSException("Interview Id already exist... Please choose different one!");
            }
            
        	interview = toInterviewModel(interviewRepo.save(toInterviewEntity(interview)));
        }
        return interview;
	}
	
	@Override
	public InterviewModel getInterview(Integer interviewId) {
        Interview interview = interviewRepo.findById(interviewId).orElse(null);
        return interview!=null?toInterviewModel(interview):null;
    }
	
	@Override
	public boolean deleteInterview(Integer interviewId) throws ITSException {
		if(!interviewRepo.existsById(interviewId)) {
			throw new ITSException("Interview Id not found or already deleted!");
		}	
		
		Interview interview = interviewRepo.findById(interviewId).orElse(null);
		interview.removeAttendees();
		interviewRepo.flush();
		interviewRepo.delete(interview);
		return true;
	}
	
	private InterviewModel getInterviewModel(Interview entity) {
		return new InterviewModel(entity.getInterviewId(), entity.getInterviewerName(), entity.getInterviewName(), entity.getUsersSkills(), entity.getTime(), entity.getDate(), entity.getInterviewStatus(), entity.getRemarks());
	}
	
	@Override
	public Set<InterviewModel> getAllInterviews() {
		Set<InterviewModel> models=null;
		Set<Interview> interviews= new HashSet<Interview>(interviewRepo.findAll());
		if(interviews!=null && !interviews.isEmpty()) {
			models = interviews.stream().map(e -> getInterviewModel(e)).collect(Collectors.toSet());
		}
		return models;
	}
	
	@Override
	public Integer getInterviewsCount() {
		Set<Interview> interviews=  new HashSet<Interview>(interviewRepo.findAll());
		return interviews.size();
	}
	
	@Override
	public InterviewModel updateInterviewStatus(Integer interviewId, String status) throws ITSException {
		if(!interviewRepo.existsById(interviewId)) {
			throw new ITSException("Interview Id not found!");
		}
		InterviewModel interview = getInterview(interviewId);
		interview.setInterviewStatus(status);
		interviewRepo.save(toInterviewEntity(interview));
		return getInterviewModel(toInterviewEntity(interview));
	}
	
	@Override
	public Set<InterviewModel> searchInterviewByName(String interviewName, String interviewerName) {
		Set<InterviewModel> interviewModels=null;
		Set<Interview> interviews= new HashSet<Interview>(interviewRepo.findByName(interviewName, interviewerName));
		
		if(interviews!=null && !interviews.isEmpty()) {
			interviewModels = interviews.stream().map(e -> getInterviewModel(e)).collect(Collectors.toSet());
		}
		
		return interviewModels;
	}
	
	
	@Override
	public Set<UserModel> showAttendees(Integer interviewId) throws ITSException {
		
		if(!interviewRepo.existsById(interviewId)) {
            throw new ITSException("Interview Id not found!");
        }
		return toUserModels(interviewRepo.findById(interviewId).orElse(null).getAttendees());
	}
	
	@Override
	@Transactional
	public void addAttendee(AttendeeModel attendee) throws ITSException {
		
			if(!userRepo.existsById(attendee.getUserId())) {
				throw new ITSException("User id doesn't exist!");
			}
			
	        if(!interviewRepo.existsById(attendee.getInterviewId())) {
	            throw new ITSException("Interview id doesn't exist!");
	        }
	        
	        InterviewModel interview = getInterview(attendee.getInterviewId());
	        for(UserModel user: interview.getAttendee()) {
	        	if(user.getUserId() == attendee.getUserId()) {
	        		throw new ITSException("User has already applied on this interview!");
	        	}
	        }
	        
	        Set<UserModel> users=interview.getAttendee();	        
	        users.add(getUser(attendee.getUserId()));
	        interview.setAttendee(users);
	        interviewRepo.save(toInterviewEntity(interview));
	       		
	}

	public UserModel getUser(int userId) {
	    User user = userRepo.findById(userId).orElse(null);
	    return user!=null?toUserModel(user):null;
	}
	
}
