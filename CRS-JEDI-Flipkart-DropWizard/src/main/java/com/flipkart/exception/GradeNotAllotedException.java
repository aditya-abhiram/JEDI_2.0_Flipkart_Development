package com.flipkart.exception;


public class GradeNotAllotedException extends Exception {

    private String studentId;

    public GradeNotAllotedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Grade not allotted for student with ID: " + studentId;
    }
}
