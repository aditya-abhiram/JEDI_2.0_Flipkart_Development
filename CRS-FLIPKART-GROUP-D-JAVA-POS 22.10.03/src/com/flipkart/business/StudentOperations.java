package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.dao.StudentDaoOperations;
import com.flipkart.exception.CourseNotFoundException;

public class StudentOperations implements StudentInterface {

    /**
     * Initiates the course registration process.
     * Currently, this method is a placeholder and does not perform any operations.
     */
    @Override
    public void initiateRegistration() {
        System.out.println("dbed"); // Placeholder message for debugging
    }

    /**
     * Retrieves and displays all available courses.
     * This method fetches the list of courses from the database and prints their details.
     
     */
    @Override
    public void viewCourses() {
        StudentDaoOperations studentDao = new StudentDaoOperations();
        List<Course> courses = studentDao.viewCourses();
        
        // Print header for course details
        System.out.printf("%-10s %-20s %-20s %-15s %-12s %-6s\n",
                "Course ID", "Course Name", "Instructor Name", "Instructor ID", "Filled Seats", "Credit");
        System.out.println("-------------------------------------------------------------------------------------------");

        // Filter and print course details
        courses.stream()
            .filter(course -> course.getFilledSeats() < 50)  // Only display courses with fewer than 50 filled seats
            .forEach(course -> System.out.printf("%-10d %-20s %-20s %-15d %-12d %-6d\n",
                                           course.getCourseId(),
                                           course.getCourseName(),
                                           course.getInstructorName(),
                                           course.getInstructorId(),
                                           course.getFilledSeats(),
                                           course.getCredit()));
    }

    /**
     * Registers a student for a course.
     * 
     * @param studentId The ID of the student registering for the course.
     * @param courseId The ID of the course to be registered.
     * @throws CourseNotFoundException If the specified course is not found.
     */
    @Override
    public void addCourse(int studentId, int courseId) throws CourseNotFoundException {
        StudentDaoOperations studentDao = new StudentDaoOperations();
        studentDao.addCourse(studentId, courseId);
    }

    /**
     * Retrieves and displays all courses registered by a student.
     * 
     * @param studentId The ID of the student whose registered courses are to be displayed.
     */
    @Override
    public void viewRegisteredCourses(int studentId) {
        StudentDaoOperations studentDao = new StudentDaoOperations();
        List<RegisteredCourse> registeredCourses = studentDao.viewRegisteredCourses(studentId);
        
        // Print header for registered course details
        System.out.printf("%-10s %-10s %-25s %-10s %-6s\n",
                "Student ID", "Course ID", "Course Name", "Grade", "Credit");
        System.out.println("-------------------------------------------------------------------");

        // Iterate over and print registered course details
        registeredCourses.forEach(course -> System.out.printf("%-10d %-10d %-25s %-10s %-6d\n",
                                                     studentId,
                                                     course.getCourseId(),
                                                     course.getRegisteredCoursename(),
                                                     course.getGrade(),
                                                     course.getCredit()));
        
        System.out.println("working stream api"); // Placeholder message for debugging
    }

    /**
     * Drops a course for a student.
     * 
     * @param studentId The ID of the student dropping the course.
     * @param courseId The ID of the course to be dropped.
     */
    @Override
    public void dropCourse(int studentId, int courseId) {
        StudentDaoOperations studentDao = new StudentDaoOperations();
        studentDao.dropCourse(studentId, courseId);
    }
}
