package com.flipkart.exception;


public class ReportCardNotGeneratedException extends Exception {

    private String studentId;

    public ReportCardNotGeneratedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Report card not generated for student with ID: " + studentId;
    }
}
