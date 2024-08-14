package com.flipkart.exception;



public class CourseAlreadyOptedException extends Exception {

    private String studentId;
    private String courseId;

    public CourseAlreadyOptedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " already opted by student with ID: " + studentId;
    }
}
