package com.flipkart.dao;

import java.util.Set;


import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;

import java.util.Set;

/**
 * Interface for admin data access object (DAO) operations.
 * Provides methods for managing professors, courses, and student registrations.
 */
public interface AdminDaoInterface {

    /**
     * Adds a new professor to the system.
     * @param prof The `Prof` object representing the new professor.
     * @param username The username of the admin adding the professor.
     * @return A `String` message indicating the result of the addition operation (e.g., success or failure).
     * @throws UserAlreadyExistsException If a professor with the same ID or username already exists.
     */
    public String addProf(Prof prof, String username) throws UserAlreadyExistsException;

    /**
     * Removes a professor from the system.
     * @param profID The ID of the professor to be removed.
     * @return `true` if the professor was successfully removed; `false` otherwise.
     * @throws UserNotFoundException If no professor with the given ID is found.
     */
    public boolean removeProf(String profID) throws UserNotFoundException;

    /**
     * Updates an existing course with new details.
     * @param courseCode The code of the course to be updated.
     * @param updatedCourse The `Course` object containing the updated course details.
     * @return `true` if the course was successfully updated; `false` otherwise.
     * @throws CourseAlreadyExistsException If a course with the new details already exists.
     * @throws CourseNotFoundException If no course with the given code is found.
     */
    public boolean updateCourse(String courseCode, Course updatedCourse) throws CourseAlreadyExistsException, CourseNotFoundException;

    /**
     * Adds a new course to the catalog.
     * @param course The `Course` object representing the new course.
     * @return `true` if the course was successfully added; `false` otherwise.
     * @throws CourseAlreadyExistsException If a course with the same ID already exists.
     */
    public boolean addCourse(Course course) throws CourseAlreadyExistsException;

    /**
     * Removes a course from the catalog.
     * @param courseID The ID of the course to be removed.
     * @return `true` if the course was successfully removed; `false` otherwise.
     * @throws CourseNotFoundException If no course with the given ID is found.
     */
    public boolean removeCourse(String courseID) throws CourseNotFoundException;

    /**
     * Registers a student based on their ID.
     * @param studentID The ID of the student to be registered.
     * @return `true` if the student was successfully registered; `false` otherwise.
     * @throws UserNotFoundException If no student with the given ID is found.
     */
    public boolean registerStudent(String studentID) throws UserNotFoundException;

    /**
     * Retrieves the list of all available courses.
     * @return A `Set<Course>` containing all the courses in the catalog.
     */
    public Set<Course> viewCourses();

    /**
     * Retrieves the list of all professors.
     * @return A `Set<Prof>` containing all the professors.
     */
    public Set<Prof> viewProfessors();

    /**
     * Retrieves the list of students whose registrations are not yet approved.
     * @return A `Set<Student>` containing all the unapproved students.
     */
    public Set<Student> viewUnapprovedStudents();
}
