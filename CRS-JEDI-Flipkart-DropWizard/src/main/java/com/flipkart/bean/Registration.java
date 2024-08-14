package com.flipkart.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author JEDI-03
 * Class to handle course registration information for students
 * 
 */
public class Registration {
	private boolean status;
    private long studentID;
    private Date date;
    private List<CourseRegistered> courseRegistrations; // List of registered courses

    /**
     * Parameterized constructor
     * @param studentID: the ID of the student
     * @param date: the registration date
     */
    public Registration(long studentID, Date date) {
        this.studentID = studentID;
        this.date = date;
        this.courseRegistrations = new ArrayList<>();
    }

    // Getters and Setters
    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CourseRegistered> getCourseRegistrations() {
        return courseRegistrations;
    }

    public void setCourseRegistrations(List<CourseRegistered> courseRegistrations) {
        this.courseRegistrations = courseRegistrations;
    }

    /**
     * Method to register a course for the student
     * @param course: the course to register
     * @return true if registration was successful, false otherwise
     */
    public boolean registerCourse(Course course) {
        CourseRegistered newRegistration = new CourseRegistered(course.getCourseID(), (int)studentID);
        return courseRegistrations.add(newRegistration);
    }

    /**
     * Method to notify the student for fee payment
     * @return notification message
     */
    public String notifyForFee() {
        return "Fee notification: Please pay the outstanding fee.";
    }

    /**
     * Method to view registered courses
     * @return list of registered courses
     */
    public List<Course> viewRegisteredCourses() {
        List<Course> courses = new ArrayList<>();
        //
        return courses;
    }

    /**
     * Method to get a list of available courses
     * @param allCourses: list of all available courses
     * @return list of available courses
     */
    public List<Course> availableCourses(List<Course> allCourses) {
    	List<Course> courses = new ArrayList<>();
        //
        return courses;
    }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
