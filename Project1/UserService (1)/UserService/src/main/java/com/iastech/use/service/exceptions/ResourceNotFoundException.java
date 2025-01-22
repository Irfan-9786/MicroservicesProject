package com.iastech.use.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
public ResourceNotFoundException() {
	super("Resource Not Found in Database...!!!");
}
public ResourceNotFoundException(String message) {
	super(message);
}
}
