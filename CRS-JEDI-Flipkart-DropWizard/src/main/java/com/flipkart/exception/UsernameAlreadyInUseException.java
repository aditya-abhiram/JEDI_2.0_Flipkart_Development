package com.flipkart.exception;

public class UsernameAlreadyInUseException extends Exception {

    private String username;

    public UsernameAlreadyInUseException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Email: " + username + " is already in use.";
    }
}
