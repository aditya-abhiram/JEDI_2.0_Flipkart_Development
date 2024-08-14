package com.flipkart.business;

/**
 * Interface representing the operations available to a Professor.
 * Provides methods to view courses, students, and to grade students.
 */
public interface ProfessorInterface {

    /**
     * Retrieves and displays the list of courses available to the professor.
     * 
     * @param professorId The ID of the professor requesting to view courses.
     * This method should display all courses assigned to or available for the professor.
     */
    void viewCourses(int professorId);

    /**
     * Retrieves and displays the list of students associated with the professor.
     * 
     * @param professorId The ID of the professor requesting to view students.
     * This method should display all students taught by or related to the professor.
     */
    void viewStudents(int professorId);

    /**
     * Assigns a grade to a student for a specific course.
     * 
     * @param professorId The ID of the professor assigning the grade.
     * @param studentId The ID of the student who is receiving the grade.
     * @param courseId The ID of the course for which the grade is being assigned.
     * This method should update the student's grade for the specified course.
     */
    void gradeStudent(int professorId, int studentId, int courseId);
}
