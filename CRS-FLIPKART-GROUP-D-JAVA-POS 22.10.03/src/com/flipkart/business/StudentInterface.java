package com.flipkart.business;

import com.flipkart.exception.CourseNotFoundException;

/**
 * Interface representing the operations available to a Student.
 * Provides methods to register for courses, view available courses, add or drop courses, and view registered courses.
 */
public interface StudentInterface {

    /**
     * Initiates the student registration process.
     * This method should handle any necessary steps to register a new student.
     */
    void initiateRegistration();

    /**
     * Retrieves and displays the list of available courses.
     * This method should show all courses that the student can choose from.
     */
    void viewCourses();

    /**
     * Adds a course to the student's list of registered courses.
     * 
     * @param studentId The ID of the student registering for the course.
     * @param courseId The ID of the course the student wants to add.
     * @throws CourseNotFoundException If the specified course does not exist.
     * This method should update the student's registered courses and handle any errors if the course is not found.
     */
    void addCourse(int studentId, int courseId) throws CourseNotFoundException;

    /**
     * Retrieves and displays the list of courses that the student has registered for.
     * 
     * @param studentId The ID of the student whose registered courses are being viewed.
     * This method should show all courses that the student has currently registered for.
     */
    void viewRegisteredCourses(int studentId);

    /**
     * Removes a course from the student's list of registered courses.
     * 
     * @param studentId The ID of the student dropping the course.
     * @param courseId The ID of the course the student wants to drop.
     * This method should update the student's registered courses and handle the removal of the course.
     */
    void dropCourse(int studentId, int courseId);
}
