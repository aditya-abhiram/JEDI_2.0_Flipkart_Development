package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.ProfessorOperations;

public class ProfessorClient {
    
    /**
     * Displays the professor menu and handles user interactions for professor activities.
     * 
     * @param professorId The ID of the professor performing the actions.
     */
    public void createProfessorMenu(int professorId) {
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to Professor Activity");
            System.out.println("1. View Courses");
            System.out.println("2. View Students");
            System.out.println("3. Grade Student");
            System.out.println("4. Logout");
            
            Scanner sc = new Scanner(System.in);
            int professorActivity = sc.nextInt();
            
            switch(professorActivity) {
                case 1:
                    viewCourses(professorId); // Handles viewing courses
                    break;
                case 2:
                    viewStudents(professorId); // Handles viewing students
                    break;
                case 3:
                    gradeStudent(professorId); // Handles grading a student
                    break;
                case 4:
                    System.out.println("Logged out"); // Logs out and exits the menu
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice"); // Handles invalid menu choices
                    flag = false;
                    break;
            }
        }
    }
    
    /**
     * Retrieves and displays courses associated with the given professor ID.
     * 
     * @param professorId The ID of the professor whose courses are to be viewed.
     */
    void viewCourses(int professorId) {
        ProfessorOperations pOp = new ProfessorOperations();
        pOp.viewCourses(professorId);
    }
    
    /**
     * Retrieves and displays students associated with the given professor ID.
     * 
     * @param professorId The ID of the professor whose students are to be viewed.
     */
    void viewStudents(int professorId) {
        ProfessorOperations pOp = new ProfessorOperations();
        pOp.viewStudents(professorId);
    }
    
    /**
     * Prompts for student ID and course ID, then grades the student for the given course.
     * 
     * @param professorId The ID of the professor who is grading the student.
     */
    void gradeStudent(int professorId) {
        ProfessorOperations pOp = new ProfessorOperations();
        pOp.viewStudents(professorId); // Ensure student exists before grading
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID");
        int studentId = sc.nextInt();
        System.out.println("Enter course ID");
        int courseId = sc.nextInt();
        
        pOp.gradeStudent(professorId, studentId, courseId);
    }
}
