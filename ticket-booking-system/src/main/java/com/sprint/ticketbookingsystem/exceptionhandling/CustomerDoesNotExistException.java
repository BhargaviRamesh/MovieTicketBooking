package com.sprint.ticketbookingsystem.exceptionhandling;

public class CustomerDoesNotExistException extends Exception {
	public CustomerDoesNotExistException() {
		super();
	}

	public CustomerDoesNotExistException(String message) {
		super(message);
	}

}
