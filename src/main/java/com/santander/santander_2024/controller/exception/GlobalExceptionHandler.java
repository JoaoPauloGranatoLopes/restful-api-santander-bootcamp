package com.santander.santander_2024.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
		return new ResponseEntity<>(businessException
					.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException){
		return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedExcepion){
		var message = "Unexpected Server Error, see logs.";
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
