package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.business.AdminOperations;

import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;

public class AdminClient {
    Scanner in = new Scanner(System.in);
    
    /**
     * Displays the admin menu and handles user interactions for admin activities.
     * 
     * @param adminId The ID of the admin performing the actions.
     * @throws CourseNotAddedException If an error occurs while adding a course.
     * @throws StudentNotApprovedException If an error occurs while approving a student.
     * @throws StudentNotFoundException If the student to be approved is not found.
     * @throws ProfessorNotAddedException If an error occurs while adding a professor.
     */
    public void createAdminMenu(int adminId) throws CourseNotAddedException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException {
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to Admin Activity");
            System.out.println("1. Authenticate Student");
            System.out.println("2. Add course in Course List");
            System.out.println("3. Add Professor");
            System.out.println("4. View all students");
            System.out.println("5. View all professors");
            System.out.println("6. View all courses");
            System.out.println("7. Logout");
            
            int adminActivity = in.nextInt();
            in.nextLine();
            
            switch(adminActivity) {
            case 1:
                authenticateStudentRegistration(); // Handles student authentication
                break;
            case 2:
                addCourseInCourseList(); // Adds a new course to the course list
                break;
            case 3:
                addProfessor(); // Adds a new professor
                break;
            case 4:
                viewAllStudents(); // Views all registered students
                break;
            case 5:
                viewAllProfessors(); // Views all professors
                break;
            case 6:
                viewAllCourses(); // Views all courses
                break;
            case 7:
                flag = false; // Logs out and exits the menu
                break;
            default:
                System.out.println("Enter a valid choice"); // Handles invalid menu choices
                break;
            }
        }
    }
    
    /**
     * Displays all professors and allows adding a new professor.
     */
    private void viewAllProfessors() {
        AdminOperations adminOp = new AdminOperations();
        adminOp.viewAllProfessors();
    }
    
    /**
     * Displays all students and allows approving a student.
     */
    private void viewAllStudents() {
        AdminOperations adminOp = new AdminOperations();
        adminOp.viewAllStudents();
    }
    
    /**
     * Displays all courses and allows adding a new course.
     */
    private void viewAllCourses() {
        AdminOperations adminOp = new AdminOperations();
        adminOp.viewAllCourses();
    }
    
    /**
     * Prompts for a student ID and approves the student registration.
     * 
     * @throws StudentNotApprovedException If an error occurs while approving the student.
     * @throws StudentNotFoundException If the student with the given ID is not found.
     */
    private void authenticateStudentRegistration() throws StudentNotApprovedException, StudentNotFoundException {
        AdminOperations adminOp = new AdminOperations();
        adminOp.viewAllStudents();
        System.out.println("Enter student id/user id");
        Scanner sc = new Scanner(System.in);
        int studentId = sc.nextInt();
        
        adminOp.approveStudent(studentId);
    }
    
    /**
     * Prompts for course details and adds a new course to the list.
     * 
     * @throws CourseNotAddedException If an error occurs while adding the course.
     */
    private void addCourseInCourseList() throws CourseNotAddedException {
        int courseId;
        String courseName;
        int instructorId;
        String instructorName;
        int filledSeats;
        int credit;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Course ID: ");
        courseId = scanner.nextInt();
        
        System.out.print("Enter Course Name: ");
        courseName = scanner.next();
        
        System.out.print("Enter Instructor ID: ");
        instructorId = scanner.nextInt();
        
        System.out.print("Enter Instructor Name: ");
        instructorName = scanner.next();
        
        System.out.print("Enter Filled Seats: ");
        filledSeats = scanner.nextInt();
        
        System.out.print("Enter Credit: ");
        credit = scanner.nextInt();
        
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCredit(credit);
        course.setFilledSeats(filledSeats);
        course.setInstructorId(instructorId);
        course.setInstructorName(instructorName);
        
        AdminOperations adminOp = new AdminOperations();
        adminOp.addCourse(course);
    }
    
    /**
     * Prompts for professor details and adds a new professor.
     * 
     * @throws ProfessorNotAddedException If an error occurs while adding the professor.
     */
    private void addProfessor() throws ProfessorNotAddedException {
        int professorId;
        String department;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Professor ID: ");
        professorId = scanner.nextInt();
        
        System.out.print("Enter Professor Department: ");
        department = scanner.next();
        
        Professor professor = new Professor();
        professor.setDepartment(department);
        professor.setProfessorId(professorId);
        
        AdminOperations adminOp = new AdminOperations();
        adminOp.addProfessor(professor);
    }
}
