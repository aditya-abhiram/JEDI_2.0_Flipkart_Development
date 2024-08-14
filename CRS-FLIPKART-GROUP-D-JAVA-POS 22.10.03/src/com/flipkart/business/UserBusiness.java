package com.flipkart.business;

import com.flipkart.dao.UserDaoOperations;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

public class UserBusiness implements UserInterface {

    /**
     * Handles the user signup process.
     * 
     * @param userId The ID of the new user.
     * @param password The password for the new user.
     * @param role The role assigned to the new user (e.g., student, professor).
     * @throws RoleNotFoundException If the provided role is not valid.
     * @throws UserIdAlreadyInUseException If the user ID is already in use.
     */
    @Override
    public void signup(int userId, String password, String role) throws RoleNotFoundException, UserIdAlreadyInUseException {
        UserDaoOperations userDao = new UserDaoOperations();
        // Calls the DAO method to handle user signup
        userDao.signup(userId, password, role);
    }

    /**
     * Handles the user login process.
     * 
     * @param userId The ID of the user attempting to log in.
     * @param password The password for the user.
     * @throws UserNotFoundException If the user with the specified ID is not found.
     * @throws CourseNotAddedException If an error occurs while adding a course (not directly related to login but included in the method signature).
     * @throws CourseNotFoundException If the specified course is not found (not directly related to login but included in the method signature).
     * @throws StudentNotApprovedException If the student is not approved (not directly related to login but included in the method signature).
     * @throws StudentNotFoundException If the student with the specified ID is not found (not directly related to login but included in the method signature).
     * @throws ProfessorNotAddedException If the professor is not added (not directly related to login but included in the method signature).
     */
    @Override
    public void login(int userId, String password) throws UserNotFoundException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException {
        UserDaoOperations userDao = new UserDaoOperations();
        // Calls the DAO method to handle user login
        userDao.login(userId, password);
    }
}
