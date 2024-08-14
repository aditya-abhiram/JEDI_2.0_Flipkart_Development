package com.flipkart.exception;

public class ProfessorNotFoundException extends Exception {

    private String professorId;

    public ProfessorNotFoundException(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "Professor with ID: " + professorId + " not found.";
    }
}
