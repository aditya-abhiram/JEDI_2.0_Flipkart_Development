package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.CourseNotFoundException;

/**
 * Interface for Student Data Access Object (DAO) operations.
 * Provides methods for interacting with student-related data in the database.
 */
public interface StudentDaoInterface {

    /**
     * Retrieves the list of all available courses.
     * 
     * @return A list of {@link Course} objects representing all courses available.
     */
    List<Course> viewCourses();

    /**
     * Retrieves the list of courses that a specific student has registered for.
     * 
     * @param studentId The ID of the student whose registered courses are to be retrieved.
     * @return A list of {@link RegisteredCourse} objects representing the courses registered by the student.
     */
    List<RegisteredCourse> viewRegisteredCourses(int studentId);

    /**
     * Adds a course to the student's registered courses.
     * 
     * @param studentId The ID of the student who wants to register for the course.
     * @param courseId The ID of the course to be added.
     * @throws CourseNotFoundException If the course with the specified ID does not exist.
     * This method should handle adding the course to the student's registration list and updating any relevant details.
     */
    void addCourse(int studentId, int courseId) throws CourseNotFoundException;

    /**
     * Removes a course from the student's registered courses.
     * 
     * @param studentId The ID of the student who wants to drop the course.
     * @param courseId The ID of the course to be removed.
     * This method should handle removing the course from the student's registration list and updating any relevant details.
     */
    void dropCourse(int studentId, int courseId);
}
