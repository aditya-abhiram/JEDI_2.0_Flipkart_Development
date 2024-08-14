package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UsernameAlreadyInUseException;

/**
 * Interface for user data access object (DAO) operations.
 * Provides methods for retrieving user information, registering students, and updating user passwords.
 */
public interface UserDaoInterface {

    /**
     * Retrieves a user by their username.
     * @param username The username of the user to retrieve.
     * @return The `User` object associated with the specified username.
     * @throws UserNotFoundException If no user with the specified username is found.
     */
    User getUser(String username) throws UserNotFoundException, StudentNotApprovedException;

    /**
     * Registers a new student.
     * @param username The username for the new student.
     * @param name The name of the student.
     * @param contact The contact number of the student.
     * @param email The email address of the student.
     * @param password The password for the student's account.
     * @param branch The branch of study for the student.
     * @return A `String` indicating the result of the registration process (e.g., success or failure message).
     * @throws UsernameAlreadyInUseException If the username is already in use.
     */
    String registerStudent(String username, String name, String contact, String email, String password, String branch) throws UsernameAlreadyInUseException;

    /**
     * Updates the password for a user.
     * @param username The username of the user whose password is to be updated.
     * @param oldPassword The current password of the user.
     * @param newPassword The new password to set.
     * @return `true` if the password was successfully updated; `false` otherwise.
     * @throws UserNotFoundException If no user with the specified username is found.
     */
    boolean updatePassword(String username, String oldPassword, String newPassword) throws UserNotFoundException;
}