package com.flipkart.exception;

public class StudentNotApprovedException extends Exception {

	public StudentNotApprovedException(String message) {
		super(message);
	}

	public StudentNotApprovedException() {
		super();
	}

}
