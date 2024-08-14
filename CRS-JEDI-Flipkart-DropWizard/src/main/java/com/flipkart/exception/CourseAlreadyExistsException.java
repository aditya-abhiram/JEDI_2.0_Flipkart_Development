package com.flipkart.exception;


public class CourseAlreadyExistsException extends Exception {

    private String courseId;

    public CourseAlreadyExistsException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " already exists.";
    }
}
