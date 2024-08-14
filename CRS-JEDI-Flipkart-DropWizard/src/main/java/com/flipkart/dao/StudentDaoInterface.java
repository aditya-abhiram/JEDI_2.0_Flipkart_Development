package com.flipkart.dao;

import java.util.List;
import java.util.Set;

import com.flipkart.bean.Billing;
import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.BillingNotFoundException;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;

public interface StudentDaoInterface {

    /**
     * Registers a student for a course.
     * @param student The `Student` object representing the student registering for the course.
     * @param coursesID The ID of the course to be registered for.
     * @return The total cost for the registered course.
     * @throws CourseAlreadyOptedException If the student has already opted for the course.
     * @throws CourseNotAvailableException If the course is not available.
     * @throws CourseNotFoundException If the course with the specified ID is not found.
     */
    public float register(Student student, String coursesID) 
        throws CourseAlreadyOptedException, CourseNotAvailableException, CourseNotFoundException;

    /**
     * Retrieves the list of courses a student is currently enrolled in.
     * @param student The `Student` object representing the student whose courses are to be retrieved.
     * @return A `List<Course>` containing the courses the student is currently enrolled in.
     */
    public List<Course> viewCoursesEnrolled(Student student);

    /**
     * Retrieves the list of all available courses.
     * @return A `Set<Course>` containing all the available courses.
     */
    public Set<Course> viewCourses();

    /**
     * Retrieves the report card for a specific student.
     * @param student The `Student` object representing the student whose report card is to be retrieved.
     * @return A `ReportCard` object containing the student's academic report.
     */
    public ReportCard getReport(Student student);

    /**
     * Retrieves billing information for a specific student.
     * @param student The `Student` object representing the student whose billing information is to be retrieved.
     * @return A `Billing` object containing the billing information.
     * @throws BillingNotFoundException If the billing information for the student is not found.
     */
    public Billing getBillingInfo(Student student) throws BillingNotFoundException;

    /**
     * Updates the billing information for a specific student.
     * @param billing The `Billing` object containing the updated billing information.
     * @return `true` if the billing information was successfully updated; `false` otherwise.
     */
    public boolean updateBillingInfo(Billing billing);
}