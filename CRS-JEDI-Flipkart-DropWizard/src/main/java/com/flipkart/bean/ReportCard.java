package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author JEDI-03
 * Class to manage and display a student's report card
 * 
 */
public class ReportCard {

    private String studentID; // ID of the student
    private Map<String, String> grades; // Map to store course IDs and corresponding grades

    /**
     * Parameterized constructor
     * @param studentID: ID of the student
     */
    public ReportCard(String studentID) {
        this.studentID = studentID;
        this.grades = new HashMap<>();
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, String> grades) {
        this.grades = grades;
    }
    
    public void addOrUpdateGrade(String courseID, String grade) {
    	grades.put(courseID,grade);
    }

    /**
     * Method to display the student's report card
     * @return a string representation of the report card
     */
    public Map<String,String> showReport() {
        return grades;
    }
}
