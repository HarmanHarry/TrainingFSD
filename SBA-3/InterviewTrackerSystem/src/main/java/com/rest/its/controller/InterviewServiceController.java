package com.rest.its.controller;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.its.exception.ITSException;
import com.rest.its.model.AttendeeModel;
import com.rest.its.model.InterviewModel;
import com.rest.its.model.UserModel;
import com.rest.its.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewServiceController {

	@Autowired
	private InterviewService interviewService;
	
	@PostMapping("/newInterview")
	public ResponseEntity<InterviewModel> addNewInterview(@RequestBody @Valid InterviewModel interview,BindingResult result) throws ITSException{
		if(result.hasErrors()) {
			throw new ITSException(GlobalExceptionController.errorMsg(result));
		}
		return new ResponseEntity<>(interviewService.addInterview(interview),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getInterview(@PathVariable("id")int interviewId){
		ResponseEntity<Object> response=null;		
		InterviewModel interview = interviewService.getInterview(interviewId);
		
		if(interview==null)
			response =new ResponseEntity<>("Interview not found with id - "+interviewId,HttpStatus.NOT_FOUND);
			else
				response =new ResponseEntity<>(interview,HttpStatus.OK);
				
		return response;
	}
	
	@GetMapping("/getAllInterviews")
	public ResponseEntity<Set<InterviewModel>> getAllInterviews(){
		return new ResponseEntity<Set<InterviewModel>>(interviewService.getAllInterviews(),HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<String> getInterviewsCount(){
		return new ResponseEntity<>("Total Number of Interviews Count - "+interviewService.getInterviewsCount(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInterview(@PathVariable("id")int interviewId) throws ITSException{
		interviewService.deleteInterview(interviewId);		
		return new ResponseEntity<>("Interview with id-'"+interviewId+"' deleted Successfully",HttpStatus.OK);
	}
	
	@PutMapping("/status/{interviewid}/{status}")
	public ResponseEntity<InterviewModel> updateInterviewStatus(@PathVariable("interviewid")int interviewId,@PathVariable("status")String status) throws ITSException{
		return new ResponseEntity<>(interviewService.updateInterviewStatus(interviewId, status),HttpStatus.OK);
	}
	
	@GetMapping("/search/{InterviewName}/{InterviewerName}")
	public ResponseEntity<Set<InterviewModel>> searchInterviewByName(@PathVariable("InterviewName")String interviewName, @PathVariable("InterviewerName")String interviewerName){
		ResponseEntity<Set<InterviewModel>> response=null;
		Set<InterviewModel> interview = interviewService.searchInterviewByName(interviewName, interviewerName);
		
		if(interview==null) 
			response =new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		else 
			response =new ResponseEntity<>(interview,HttpStatus.OK);
		
		
		return response;
	}
	
	
	@PutMapping("/newAttendee")
	public ResponseEntity<String> addAttendee(@RequestBody @Valid AttendeeModel attendee,BindingResult result) throws ITSException{
		if(result.hasErrors()) {
			throw new ITSException(GlobalExceptionController.errorMsg(result));
		}
		interviewService.addAttendee(attendee);
		return new ResponseEntity<>("User has successfully applied for the Interview",HttpStatus.OK);
	}
	
	@GetMapping("/showAttendees/{id}")
	public ResponseEntity<Set<UserModel>> showAttendees(@PathVariable("id")int interviewId) throws ITSException{
		return new ResponseEntity<>(interviewService.showAttendees(interviewId),HttpStatus.OK);
	}
}
