package com.flipkart.exception;

public class ProfessorAlreadyExistsException extends Exception {

    private String professorId;

    public ProfessorAlreadyExistsException(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "Professor with ID: " + professorId + " already exists.";
    }
}
