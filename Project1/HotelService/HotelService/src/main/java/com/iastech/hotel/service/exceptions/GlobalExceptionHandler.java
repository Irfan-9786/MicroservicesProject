package com.iastech.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<Object> resourceNotFoundExceptionHandler(ResourceNotFoundException r){
	String message=r.getMessage();
	return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
}
}
