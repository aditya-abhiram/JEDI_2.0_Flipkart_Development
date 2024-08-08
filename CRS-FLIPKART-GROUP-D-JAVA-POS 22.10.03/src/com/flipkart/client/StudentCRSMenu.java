package com.flipkart.client;

import com.flipkart.bean.Student;
import java.util.Scanner;

public class StudentCRSMenu {
    Scanner in = new Scanner(System.in);

    public void runStudentActivity() {
        boolean continueRunning = true;

        while (continueRunning) {
            displayMenu();
            int studentActivity = getStudentActivity();

            switch (studentActivity) {
                case 1:
                    registerForCourse();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    viewGradeSheet();
                    break;
                case 5:
                    payFees();
                    break;
                case 6:
                    continueRunning = false;
                    System.out.println("Exiting Student Activity. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to Student Activity");
        System.out.println("1. Register for Course");
        System.out.println("2. Add Course");
        System.out.println("3. Drop Course");
        System.out.println("4. View Grade Sheet");
        System.out.println("5. Pay Fees");
        System.out.println("6. Exit");
    }

    private int getStudentActivity() {
        int studentActivity = -1;
        while (studentActivity < 1 || studentActivity > 6) {
            try {
                System.out.print("Please enter your choice: ");
                studentActivity = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }
        return studentActivity;
    }

    private void registerForCourse() {
        System.out.println("Course registration complete");
    }

    private void addCourse() {
        System.out.println("Course added");
    }

    private void dropCourse() {
        System.out.println("Course dropped");
    }

    private void viewGradeSheet() {
        System.out.println("Grade sheet viewed");
    }

    private void payFees() {
        System.out.println("Fees paid");
    }
}