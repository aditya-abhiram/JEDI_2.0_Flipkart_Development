package com.flipkart.business;

import java.util.HashMap;
import java.util.Map;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UsernameAlreadyInUseException;

public interface UserInterface {
    // A map storing users with their usernames as keys
    Map<String, User> users = new HashMap<>();
    
    /**
     * Retrieves a user based on their username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A `User` object if the username and password match an existing user; `null` otherwise.
     */
    public User retrieve(String username, String password) throws UserNotFoundException, StudentNotApprovedException;
    
    /**
     * Creates a new user and adds them to the system.
     * @param username The username of the new user.
     * @param user The `User` object representing the new user.
     */
    public void makeNew(String username, User user);
    
    /**
     * Changes the password for a specified user.
     * @param username The username of the user whose password is being changed.
     * @param password The current password of the user.
     * @param newPassword The new password to be set.
     * @return `true` if the password was successfully changed; `false` otherwise.
     */
    public boolean changePassword(String username, String password, String newPassword) throws UserNotFoundException;
    
    /**
     * Registers a new student with the provided details.
     * @param username The username for the new student.
     * @param name The name of the student.
     * @param contact The contact number of the student.
     * @param email The email address of the student.
     * @param password The password for the student.
     * @param branch The branch/department of the student.
     * @return A `String` message indicating the result of the registration operation (e.g., success or failure).
     */
    public String registerStudent(String username, String name, String contact, String email, String password, String branch) throws UsernameAlreadyInUseException;
    
    /**
     * Finds a user by their ID.
     * @param id The ID of the user.
     * @return The `User` object corresponding to the given ID; `null` if no such user exists.
     */
    public User findByID(String id);
    
    /**
     * Prints the details of all users in the system.
     */
    public void printUsers();
}

