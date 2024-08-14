package com.flipkart.exception;

public class BillingNotFoundException extends Exception{
	private String studentID;

    public BillingNotFoundException(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String getMessage() {
        return "Biiling ID for student " + studentID + " not found.";
    }
}
