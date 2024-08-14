package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoOperations;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;

public class AdminOperations implements AdminInterface {

    /*
      Adds a new professor to the database.
      
     
     */
    public void addProfessor(Professor professor) throws ProfessorNotAddedException {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        adminDao.addProfessor(professor);
    }

    /**
     * Approves a student by updating their approval status in the database.
     * 
     * @param studentId The ID of the student to be approved.
     * @throws StudentNotApprovedException If the student could not be approved due to any issues.
     * @throws StudentNotFoundException If the student with the specified ID is not found.
     */
    public void approveStudent(int studentId) throws StudentNotApprovedException, StudentNotFoundException {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        adminDao.approveStudent(studentId);
    }

    /**
     * Retrieves and displays all professors from the database.
     * This method fetches the list of professors, then prints their details in a formatted table.
     */
    @Override
    public void viewAllProfessors() {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        List<Professor> professors = adminDao.viewAllProfessors();

        // Print header for professor details
        System.out.printf("%-12s %-20s\n", "Professor ID", "Department");
        System.out.println("----------------------------");

        // Iterate over and print professor details
        professors.forEach(professor -> System.out.printf("%-12d %-20s\n",
                                                          professor.getProfessorId(),
                                                          professor.getDepartment()));
    }

    /**
     * Retrieves and displays all students from the database.
     * This method fetches the list of students, then prints their details in a formatted table.
     */
    @Override
    public void viewAllStudents() {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        List<Student> students = adminDao.viewAllStudents();

        // Print header for student details
        System.out.printf("%-12s %-10s %-10s %-12s\n",
                "Student ID", "Batch", "Branch", "Approved");
        System.out.println("------------------------------------------------");

        // Iterate over and print student details
        students.forEach(student -> System.out.printf("%-12d %-10s %-10s %-12s\n",
                                            student.getStudentId(),
                                            student.getBatch(),
                                            student.getBranch(),
                                            student.isApproved() ? "Yes" : "No"));
    }

    /**
     * Retrieves and displays all courses from the database.
     * This method fetches the list of courses, filters the courses with less than 50 filled seats,
     * and then prints their details in a formatted table.
     */
    @Override
    public void viewAllCourses() {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        List<Course> courses = adminDao.viewAllCourses();

        // Print header for course details
        System.out.printf("%-10s %-20s %-20s %-15s %-12s %-6s\n",
                "Course ID", "Course Name", "Instructor Name", "Instructor ID", "Filled Seats", "Credit");
        System.out.println("-------------------------------------------------------------------------------------------");

        // Filter and print course details
        courses.stream()
           .filter(course -> course.getFilledSeats() < 50)  // Filter courses with less than 50 filled seats
           .forEach(course -> System.out.printf("%-10d %-20s %-20s %-15d %-12d %-6d\n",
                                          course.getCourseId(),
                                          course.getCourseName(),
                                          course.getInstructorName(),
                                          course.getInstructorId(),
                                          course.getFilledSeats(),
                                          course.getCredit()));
    }

    /**
     * Adds a new course to the database.
     * 
     * @param course The Course object containing the course details to be added.
     * @throws CourseNotAddedException If the course could not be added due to any issues.
     */
    @Override
    public void addCourse(Course course) throws CourseNotAddedException {
        AdminDaoOperations adminDao = new AdminDaoOperations();
        adminDao.addCourse(course);
    }
}
