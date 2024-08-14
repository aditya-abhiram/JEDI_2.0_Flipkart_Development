package com.flipkart.dao;

import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * Interface for User Data Access Object (DAO) operations.
 * Defines methods for user-related database operations, such as registration and login.
 */
public interface UserDaoInterface {

    /**
     * Registers a new user in the system.
     * 
     * @param userId The unique identifier for the user.
     * @param password The password for the user account.
     * @param role The role of the user (e.g., student, professor, admin).
     * @throws RoleNotFoundException If the provided role is not recognized or valid.
     * @throws UserIdAlreadyInUseException If the user ID is already taken by another user.
     */
    void signup(int userId, String password, String role) throws RoleNotFoundException, UserIdAlreadyInUseException;

    /**
     * Authenticates a user and logs them into the system.
     * 
     * @param userId The unique identifier for the user attempting to log in.
     * @param password The password provided by the user for authentication.
     * @throws UserNotFoundException If no user is found with the given ID.
     * @throws CourseNotAddedException If there is an issue related to course addition (e.g., course data errors).
     * @throws CourseNotFoundException If the course involved in the login process cannot be found.
     * @throws StudentNotApprovedException If the student is not approved by the admin yet.
     * @throws StudentNotFoundException If the student record is not found.
     * @throws ProfessorNotAddedException If the professor has not been added properly.
     */
    void login(int userId, String password) throws UserNotFoundException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException;

}
