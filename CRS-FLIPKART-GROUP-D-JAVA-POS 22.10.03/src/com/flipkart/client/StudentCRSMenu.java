package com.flipkart.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipkart.business.StudentOperations;
import com.flipkart.exception.CourseNotFoundException;

public class StudentCRSMenu {

    /**
     * Displays the student menu and handles user interactions for student activities.
     * 
     * @param studentId The ID of the student performing the actions.
     * @throws CourseNotFoundException If a course-related error occurs.
     */
    public void createStudentMenu(int studentId) throws CourseNotFoundException {
        boolean logginFlag = true;
        Scanner sc = new Scanner(System.in);

        while (logginFlag) {
            System.out.println("----------Welcome To Student Menu : ---------- studentId : " + studentId);
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Course");
            System.out.println("4. View Registered Course");
            System.out.println("5. View Grade Card");
            System.out.println("6. Make Payment");
            System.out.println("7. Logout");
            System.out.println("---------------------------------------------");

            try {
                System.out.println("Enter operation number to perform:");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addCourse(studentId); // Handles adding a course
                        break;
                    case 2:
                        dropCourse(studentId); // Handles dropping a course
                        break;
                    case 3:
                        viewCourse(studentId); // Handles viewing available courses
                        break;
                    case 4:
                        viewRegisteredCourses(studentId); // Handles viewing registered courses
                        break;
                    case 5:
                        viewGradeCard(studentId); // Handles viewing the grade card
                        break;
                    case 6:
                        makePayment(studentId); // Initiates the payment process
                        break;
                    case 7:
                        logginFlag = false; // Logs out and exits the menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); // Handles invalid choices
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number."); // Handles invalid input
                sc.next(); // Clear the invalid input
            }
        }

        System.out.println("You are logged out.");
        sc.close();
    }

    /**
     * Displays the grade card for the given student ID.
     * 
     * @param studentId The ID of the student whose grade card is to be viewed.
     */
    public void viewGradeCard(int studentId) {
        StudentOperations sOp = new StudentOperations();
        sOp.viewRegisteredCourses(studentId); // Displays registered courses which includes grades
    }

    /**
     * Displays the available courses for the student to choose from.
     * 
     * @param studentId The ID of the student viewing the courses.
     */
    public void viewCourse(int studentId) {
        StudentOperations sOp = new StudentOperations();
        sOp.viewCourses(); // Displays all available courses
    }

    /**
     * Allows the student to drop a course.
     * 
     * @param studentId The ID of the student dropping a course.
     */
    public void dropCourse(int studentId) {
        System.out.println("Choose course to drop");
        StudentOperations sOp = new StudentOperations();
        sOp.viewRegisteredCourses(studentId); // Displays registered courses
        
        System.out.println("Enter course ID");
        Scanner sc = new Scanner(System.in);
        int courseId = sc.nextInt();
       
        sOp.dropCourse(studentId, courseId); // Drops the selected course
    }

    /**
     * Allows the student to add a course by selecting from available courses.
     * 
     * @param studentId The ID of the student adding a course.
     * @throws CourseNotFoundException If the course to be added is not found.
     */
    public void addCourse(int studentId) throws CourseNotFoundException {
        viewCourse(studentId); // Displays available courses to choose from
        
        Scanner sc = new Scanner(System.in);
        int courseId = sc.nextInt();
        
        StudentOperations sOp = new StudentOperations();
        sOp.addCourse(studentId, courseId); // Adds the selected course
    }

    /**
     * Initiates the payment process for the student.
     * 
     * @param studentId The ID of the student making the payment.
     */
    public void makePayment(int studentId) {
        System.out.println("Payment initiated"); // Placeholder for payment process
    }

    /**
     * Displays the courses that the student has registered for.
     * 
     * @param studentId The ID of the student whose registered courses are to be viewed.
     */
    public void viewRegisteredCourses(int studentId) {
        StudentOperations sOp = new StudentOperations();
        sOp.viewRegisteredCourses(studentId); // Displays registered courses
    }
}
