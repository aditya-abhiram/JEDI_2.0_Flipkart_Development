package com.flipkart.exception;



public class CourseNotAvailableException extends Exception {

    private String courseId;

    public CourseNotAvailableException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " is not available.";
    }
}
