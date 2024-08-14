package com.flipkart.dao;

public interface ProfessorDaoInterface {
    /**
     * View courses taught by the professor.
     * @param professorId The ID of the professor.
     */
    void viewCourses(int professorId);

    /**
     * View students enrolled in the courses taught by the professor.
     * @param professorId The ID of the professor.
     */
    void viewStudents(int professorId);

    /**
     * Grade a student for a specific course.
     * @param professorId The ID of the professor grading the student.
     * @param studentId The ID of the student being graded.
     * @param courseId The ID of the course for which the student is being graded.
     */
    void gradeStudent(int professorId, int studentId, int courseId);
}
