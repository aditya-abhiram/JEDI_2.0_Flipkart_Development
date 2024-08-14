package com.flipkart.exception;


public class CourseNotFoundException extends Exception {

    private String courseId;

    public CourseNotFoundException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not found.";
    }
}
