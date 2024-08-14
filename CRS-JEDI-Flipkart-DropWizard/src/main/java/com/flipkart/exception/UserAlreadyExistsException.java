package com.flipkart.exception;

public class UserAlreadyExistsException extends Exception {

    private String userId;

    public UserAlreadyExistsException(String userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "User with userID/username: " + userId + " already exists.";
    }
}
