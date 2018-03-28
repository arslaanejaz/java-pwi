package com.pwi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pwi.exception.CustomErrorType;


@ControllerAdvice(basePackages = {"com.pwi.controllers"})
@EnableWebMvc
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> catchGenericException(Exception e) {
 
		return new ResponseEntity<Object>(new CustomErrorType(e.getMessage()),HttpStatus.BAD_REQUEST);

 
	}
}
