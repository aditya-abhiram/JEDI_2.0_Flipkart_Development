package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;

public interface AdminDaoInterface {

    /**
     * Approves a student based on their student ID.
     * 
     * @param studentId The ID of the student to approve.
     * @throws StudentNotApprovedException If the student could not be approved.
     * @throws StudentNotFoundException If the student is not found.
     */
    void approveStudent(int studentId) throws StudentNotApprovedException, StudentNotFoundException;

    /**
     * Adds a new course to the system.
     * 
     * @param course The course to add.
     * @throws CourseNotAddedException If the course could not be added.
     */
    void addCourse(Course course) throws CourseNotAddedException;

    /**
     * Adds a new professor to the system.
     * 
     * @param professor The professor to add.
     * @throws ProfessorNotAddedException If the professor could not be added.
     */
    void addProfessor(Professor professor) throws ProfessorNotAddedException;

    /**
     * Retrieves a list of all professors.
     * 
     * @return A list of all professors.
     */
    List<Professor> viewAllProfessors();

    /**
     * Retrieves a list of all students.
     * 
     * @return A list of all students.
     */
    List<Student> viewAllStudents();

    /**
     * Retrieves a list of all courses.
     * 
     * @return A list of all courses.
     */
    List<Course> viewAllCourses();
}
