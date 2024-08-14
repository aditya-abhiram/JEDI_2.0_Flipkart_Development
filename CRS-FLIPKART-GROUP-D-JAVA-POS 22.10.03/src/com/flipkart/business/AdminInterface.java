package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;

/**
 * Interface representing the operations available to an Admin.
 * Provides methods to manage courses, professors, and students.
 */
public interface AdminInterface {

    /**
     * Adds a new course to the system.
     * 
     * @param course The course object containing course details to be added.
     * @throws CourseNotAddedException If the course cannot be added due to some issues (e.g., validation errors).
     */
    void addCourse(Course course) throws CourseNotAddedException;

    /**
     * Adds a new professor to the system.
     * 
     * @param professor The professor object containing professor details to be added.
     * @throws ProfessorNotAddedException If the professor cannot be added due to some issues (e.g., validation errors).
     */
    void addProfessor(Professor professor) throws ProfessorNotAddedException;

    /**
     * Approves a student's registration.
     * 
     * @param studentId The ID of the student to be approved.
     * @throws StudentNotApprovedException If the student's approval cannot be processed due to system errors or validation issues.
     * @throws StudentNotFoundException If the student with the specified ID cannot be found in the system.
     */
    void approveStudent(int studentId) throws StudentNotApprovedException, StudentNotFoundException;

    /**
     * Retrieves and displays all professors in the system.
     * The implementation should handle retrieving the list of professors and displaying it.
     */
    void viewAllProfessors();

    /**
     * Retrieves and displays all students in the system.
     * The implementation should handle retrieving the list of students and displaying it.
     */
    void viewAllStudents();

    /**
     * Retrieves and displays all courses in the system.
     * The implementation should handle retrieving the list of courses and displaying it.
     */
    void viewAllCourses();
}
