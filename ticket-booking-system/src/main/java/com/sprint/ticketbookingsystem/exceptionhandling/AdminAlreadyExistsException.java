package com.sprint.ticketbookingsystem.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AdminAlreadyExistsException extends Exception {

public AdminAlreadyExistsException() {
		
	}
	
	public AdminAlreadyExistsException(String message) {
		super(message);
	}

}
