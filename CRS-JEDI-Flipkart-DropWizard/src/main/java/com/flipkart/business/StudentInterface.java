package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.BillingNotFoundException;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;

public interface StudentInterface {

    /**
     * Registers a student for a list of courses.
     * @param student The `Student` object representing the student registering for courses.
     * @param courses A `List<String>` containing the IDs of the courses the student wishes to register for.
     * @return A `String` message indicating the result of the registration operation (e.g., success or failure).
     */
    public String register(Student student, List<String> courses) throws CourseAlreadyOptedException, CourseNotAvailableException, CourseNotFoundException;

    /**
     * Counts the number of valid courses from a list of course IDs.
     * @param courses A `List<String>` containing course IDs to be validated.
     * @return An `int` representing the number of valid courses from the list.
     */
    public int getValidCount(List<String> courses);

    /**
     * Retrieves a list of courses that the student is currently enrolled in.
     * @param student The `Student` object representing the student whose enrolled courses are to be retrieved.
     * @return A `String` representation of the list of courses the student is enrolled in.
     */
    public String viewCoursesEnrolled(Student student);

    /**
     * Retrieves the report card for a student.
     * @param student The `Student` object representing the student whose report card is to be retrieved.
     * @return A `String` representation of the student's report card.
     */
    public String getReport(Student student);

    /**
     * Retrieves billing information for a student.
     * @param student The `Student` object representing the student whose billing information is to be retrieved.
     * @return A `String` representation of the student's billing information.
     */
    public String getBillingInfo(Student student) throws BillingNotFoundException;

    /**
     * Retrieves a list of all available courses.
     * @return A `String` representation of the list of available courses.
     */
    public String viewCourses();

    /**
     * Processes a payment for a student.
     * @param student The `Student` object making the payment.
     * @param amount The amount to be paid.
     * @param transactionID The ID of the payment transaction.
     * @return A `String` message indicating the result of the payment operation (e.g., success or failure).
     */
    public String makePayment(Student student, float amount, String transactionID) throws BillingNotFoundException;

    /**
     * Retrieves the pricing information for the courses that the student is enrolled in.
     * @param student The `Student` object for which the course pricing is to be retrieved.
     * @return A `float` representing the total price of the courses the student is enrolled in.
     */
    public float getCoursePricing(Student student);
}

