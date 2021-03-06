package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CallNotFoundException extends Exception {
	
	public CallNotFoundException(String message) {
		super(message);
	}

}