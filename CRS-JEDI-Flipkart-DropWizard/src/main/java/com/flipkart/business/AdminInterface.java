package com.flipkart.business;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;

public interface AdminInterface {

    /**
     * Adds a new professor to the system.
     * @param prof The `Prof` object containing the details of the professor to be added.
     * @param username The username of the admin performing the operation.
     * @return A `String` message indicating the result of the addition operation (e.g., success or failure).
     * @throws UserAlreadyExistsException 
     */
    public String addProf(Prof prof, String username) throws UserAlreadyExistsException;

    /**
     * Removes a professor from the system using their ID.
     * @param profID The ID of the professor to be removed.
     * @return A `String` message indicating the result of the removal operation (e.g., success or failure).
     * @throws UserNotFoundException 
     */
    public String removeProf(String profID) throws UserNotFoundException;

    /**
     * Updates the details of an existing course.
     * @param courseCode The code of the course to be updated.
     * @param updatedCourse The `Course` object containing the updated details of the course.
     * @return A `String` message indicating the result of the update operation (e.g., success or failure).
     * @throws CourseNotFoundException 
     * @throws CourseAlreadyExistsException 
     */
    public String updateCourse(String courseCode, Course updatedCourse) throws CourseAlreadyExistsException, CourseNotFoundException;

    /**
     * Adds a new course to the catalog.
     * @param course The `Course` object containing the details of the course to be added.
     * @return A `String` message indicating the result of the addition operation (e.g., success or failure).
     * @throws CourseAlreadyExistsException 
     */
    public String addCourse(Course course) throws CourseAlreadyExistsException;

    /**
     * Removes a course from the catalog using its ID.
     * @param courseID The ID of the course to be removed.
     * @return A `String` message indicating the result of the removal operation (e.g., success or failure).
     * @throws CourseNotFoundException 
     */
    public String removeCourse(String courseID) throws CourseNotFoundException;

    /**
     * Approves a student's registration, allowing them to participate in courses.
     * @param studentID The ID of the student whose registration is to be approved.
     * @return A `String` message indicating the result of the registration approval (e.g., success or failure).
     * @throws UserNotFoundException 
     */
    public String registerStudent(String studentID) throws UserNotFoundException;

    /**
     * Retrieves a list of all available courses.
     * @return A `String` representation of the list of courses.
     */
    public String viewCourses();

    /**
     * Retrieves a list of all professors.
     * @return A `String` representation of the list of professors.
     */
    public String viewProfessors();

    /**
     * Retrieves a list of all students whose registration is pending approval.
     * @return A `String` representation of the list of unapproved students.
     */
    public String viewUnapprovedStudents();
}
