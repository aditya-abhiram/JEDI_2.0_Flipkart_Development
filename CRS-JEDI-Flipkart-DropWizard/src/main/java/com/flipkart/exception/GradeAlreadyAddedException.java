package com.flipkart.exception;


public class GradeAlreadyAddedException extends Exception {

    private String studentId;
    private String courseId;

    public GradeAlreadyAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Grade already added for student with ID: " + studentId + " in course with ID: " + courseId;
    }
}
