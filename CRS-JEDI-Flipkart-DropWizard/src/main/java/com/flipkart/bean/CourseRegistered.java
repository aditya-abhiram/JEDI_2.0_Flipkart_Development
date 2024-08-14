package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author JEDI-03
 * Class to manage course registration details
 * 
 */
public class CourseRegistered {

    private String courseID;
    private int studentID;
    private Map<Integer, String> studentGrades; // Map to store grades for students

    /**
     * Parameterized constructor
     * @param courseID: ID of the course
     * @param studentID: ID of the student
     */
    public CourseRegistered(String courseID, int studentID) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.studentGrades = new HashMap<>();
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Map<Integer, String> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(Map<Integer, String> studentGrades) {
        this.studentGrades = studentGrades;
    }

    /**
     * Method to view the grade of the student for the course
     * @return grade of the student
     */
    public String viewGrade() {
        return studentGrades.getOrDefault(studentID, "Grade not assigned");
    }

    /**
     * Method to drop the course for the student
     * @return true if the course was dropped successfully, false otherwise
     */
    public boolean drop() {
        if (studentGrades.containsKey(studentID)) {
            studentGrades.remove(studentID);
            return true; // Successfully dropped
        }
        return false; // Student was not registered in the course
    }

    /**
     * Method to view all students registered in the course
     * @return a map of student IDs to their grades
     */
    public Map<Integer, String> viewStudents() {
        return studentGrades;
    }

    /**
     * Method to add a student to the course with a grade
     * @param studentID: the ID of the student
     * @param grade: the grade of the student
     */
    public void addStudent(int studentID, String grade) {
        studentGrades.put(studentID, grade);
    }
}
