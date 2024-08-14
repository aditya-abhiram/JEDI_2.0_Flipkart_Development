package com.flipkart.dao;

import java.util.Set;
import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.GradeAlreadyAddedException;

/**
 * Interface for professor data access object (DAO) operations.
 * Provides methods for professors to manage course offerings and grades.
 */
public interface ProfDaoInterface {

    /**
     * Allows a professor to offer a course.
     * @param courseID The ID of the course to be offered.
     * @param prof The `Prof` object representing the professor offering the course.
     * @return `true` if the course was successfully offered; `false` otherwise.
     * @throws CourseNotAvailableException If the course with the given ID is not available in the catalog.
     */
    public boolean offerCourse(String courseID, Prof prof) throws CourseNotAvailableException;

    /**
     * Retrieves the list of all available courses.
     * @return A `Set<Course>` containing all the courses available.
     */
    public Set<Course> viewCourses();

    /**
     * Retrieves the list of students registered for a specific course.
     * @param courseID The ID of the course whose students are to be retrieved.
     * @param prof The `Prof` object representing the professor requesting the student list.
     * @return A `Set<Student>` containing students registered for the specified course.
     */
    public Set<Student> getStudents(String courseID, Prof prof);

    /**
     * Allows a professor to give a grade to a student for a specific course.
     * @param courseID The ID of the course for which the grade is being given.
     * @param studentID The ID of the student receiving the grade.
     * @param grade The grade to be given to the student.
     * @param prof The `Prof` object representing the professor giving the grade.
     * @return `true` if the grade was successfully added; `false` otherwise.
     * @throws CourseNotOptedException If the student has not opted for the given course.
     * @throws GradeAlreadyAddedException If a grade has already been added for the student in the given course.
     * @throws CourseNotOfferedException If the course is not offered by the professor.
     */
    public boolean giveGrade(String courseID, String studentID, String grade, Prof prof) 
        throws CourseNotOptedException, GradeAlreadyAddedException, CourseNotOfferedException;

    /**
     * Retrieves the list of courses currently being offered by a specific professor.
     * @param prof The `Prof` object representing the professor whose course offerings are to be retrieved.
     * @return A `Set<Course>` containing the courses being offered by the specified professor.
     */
    public Set<Course> viewCourseOffering(Prof prof);
}
