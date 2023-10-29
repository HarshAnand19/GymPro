package com.unkownkoder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> newsNotFoundExceptionHandler(UserNotFoundException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> defaultExceptionHandler(Exception ex){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
}
