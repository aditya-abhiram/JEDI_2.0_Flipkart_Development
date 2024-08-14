package com.flipkart.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipkart.business.UserBusiness;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

public class UserCRSMenu {

    /**
     * Displays the user menu for login and signup options.
     * 
     * @throws UserNotFoundException If the user is not found during login.
     * @throws RoleNotFoundException If the role provided during signup is invalid.
     * @throws UserIdAlreadyInUseException If the user ID is already in use during signup.
     * @throws CourseNotAddedException If the course is not added properly.
     * @throws CourseNotFoundException If the course is not found.
     * @throws StudentNotApprovedException If the student is not approved.
     * @throws StudentNotFoundException If the student is not found.
     * @throws ProfessorNotAddedException If the professor is not added properly.
     */
    public void createUserMenu() throws UserNotFoundException, RoleNotFoundException, UserIdAlreadyInUseException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException {
        boolean logginFlag = true;
        Scanner sc = new Scanner(System.in);

        while (logginFlag) {
            System.out.println("----------Welcome To User menu : ----------");
            System.out.println("1. Login ");
            System.out.println("2. Signup");

            try {
                System.out.println("Enter operation number to perform:");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        login(); // Handles user login
                        logginFlag = false; // Exit menu after login
                        break;
                    case 2:
                        signup(); // Handles user signup
                        logginFlag = false; // Exit menu after signup
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option."); // Handles invalid menu choices
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid credentials."); // Handles invalid input
                sc.next(); // Clear the invalid input
            }
        }

        System.out.println("You are logged out."); // Notify user about logout
        sc.close(); // Close scanner
    }

    /**
     * Handles user login process.
     * 
     * @throws UserNotFoundException If the user is not found during login.
     * @throws CourseNotAddedException If the course is not added properly.
     * @throws CourseNotFoundException If the course is not found.
     * @throws StudentNotApprovedException If the student is not approved.
     * @throws StudentNotFoundException If the student is not found.
     * @throws ProfessorNotAddedException If the professor is not added properly.
     */
    public void login() throws UserNotFoundException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user ID (integer):");
        int userId = sc.nextInt();

        System.out.println("Enter password:");
        String password = sc.next();

        UserBusiness uOp = new UserBusiness();
        uOp.login(userId, password); // Perform user login
    }

    /**
     * Handles user signup process.
     * 
     * @throws RoleNotFoundException If the role provided during signup is invalid.
     * @throws UserIdAlreadyInUseException If the user ID is already in use during signup.
     */
    public void signup() throws RoleNotFoundException, UserIdAlreadyInUseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new user ID (integer):");
        int userId = sc.nextInt();

        System.out.println("Enter new password:");
        String password = sc.next();

        System.out.println("Confirm password:");
        String confirmPassword = sc.next();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords don't match"); // Handles password mismatch
            return;
        }

        System.out.println("Enter role:");
        String role = sc.next();

        UserBusiness uOp = new UserBusiness();
        uOp.signup(userId, confirmPassword, role); // Perform user signup
    }
}
