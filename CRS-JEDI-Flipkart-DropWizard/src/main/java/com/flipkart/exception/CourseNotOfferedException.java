package com.flipkart.exception;



public class CourseNotOfferedException extends Exception {

    private String profID;
    private String courseId;

    public CourseNotOfferedException(String profID, String courseId) {
        this.profID = profID;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not opted by professor with ID: " + profID;
    }
}
