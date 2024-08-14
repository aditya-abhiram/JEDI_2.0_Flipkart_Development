package com.flipkart.exception;


public class CourseNotOptedException extends Exception {

    private String studentId;
    private String courseId;

    public CourseNotOptedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not opted by student with ID: " + studentId;
    }
}
