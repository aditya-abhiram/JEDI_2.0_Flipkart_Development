package com.flipkart.business;

import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * Interface representing the operations available to a User.
 * Provides methods for user registration and login.
 */
public interface UserInterface {

    /**
     * Registers a new user in the system.
     * 
     * @param userId The ID of the user to be registered.
     * @param password The password for the user account.
     * @param role The role of the user (e.g., "student", "professor", "admin").
     * @throws RoleNotFoundException If the specified role is not valid or recognized.
     * @throws UserIdAlreadyInUseException If the user ID is already taken by another account.
     * This method should handle user creation and store the user details in the system.
     */
    void signup(int userId, String password, String role) throws RoleNotFoundException, UserIdAlreadyInUseException;

    /**
     * Authenticates a user and initiates their session.
     * 
     * @param userId The ID of the user trying to log in.
     * @param password The password provided by the user.
     * @throws UserNotFoundException If the user with the given ID does not exist.
     * @throws CourseNotAddedException If there is an issue with course addition (possibly during login setup).
     * @throws CourseNotFoundException If a required course is not found (potentially for setup or validation).
     * @throws StudentNotApprovedException If the student has not been approved and thus cannot log in.
     * @throws StudentNotFoundException If the student record is not found.
     * @throws ProfessorNotAddedException If there is an issue related to the professor record.
     * This method should authenticate the user's credentials and proceed based on their role.
     */
    void login(int userId, String password) throws UserNotFoundException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException;
}
