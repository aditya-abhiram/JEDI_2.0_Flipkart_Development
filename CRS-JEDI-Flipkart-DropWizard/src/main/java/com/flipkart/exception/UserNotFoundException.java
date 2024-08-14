package com.flipkart.exception;

public class UserNotFoundException extends Exception{
    
    private String userId;

    public UserNotFoundException(String id) {
        userId = id;
    }

    @Override
    public String getMessage() {
        return "User with userId: " + userId + " not found.";
    }
}
