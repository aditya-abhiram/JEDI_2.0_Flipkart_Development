package com.flipkart.exception;

public class CourseNotFoundException extends Exception{

	public CourseNotFoundException(String message) {
		super(message);
	}

	public CourseNotFoundException() {
		super();
	}

}
