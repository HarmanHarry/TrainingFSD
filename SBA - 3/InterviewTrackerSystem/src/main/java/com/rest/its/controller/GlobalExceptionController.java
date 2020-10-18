package com.rest.its.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.its.exception.ITSException;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ITSException.class)
	public ResponseEntity<String> handleITSException(ITSException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static String errorMsg(BindingResult result) {
		List<FieldError> errors = result.getFieldErrors();
		List<String> errorMsgs = new ArrayList<>();		
		for (FieldError e : errors) {
			errorMsgs.add("@" + e.getDefaultMessage());
		}
		return errorMsgs.toString();
	}
}
