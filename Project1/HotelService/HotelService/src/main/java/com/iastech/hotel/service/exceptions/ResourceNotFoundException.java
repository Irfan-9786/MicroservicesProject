package com.iastech.hotel.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
public ResourceNotFoundException() {
	super("Resource not found in database...!!!");
}
public ResourceNotFoundException(String message) {
	super(message);
}

}
