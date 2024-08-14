package com.flipkart.bean;

import java.util.HashSet;
import java.util.Set;


public class Course {

	private String courseID;
	private String courseName;
	String courseProf;
	private int seats;
	String semesterID;
	private Set<String> enrolledStudents; // To keep track of enrolled students
	float price;
	/**
	 * Default Constructor
	 */
	public Course() {
		this.enrolledStudents = new HashSet<>();
	}
	
	/**
	 * Parameterized constructor
	 * @param courseID: course ID
	 * @param courseName: course name
	 * @param courseProf: professor user id
	 *  seats: seats available 
	 */
	public Course(String courseID, String courseName, String courseProf, int seats) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=0;
	}
	
	public Course(String courseID, String courseName, String courseProf, int seats, float price) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=price;
	}
	
	/**
	 * Method to get Course ID
	 * @return Course ID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Method to set Course ID
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Method to get Course Name
	 * @return Course Name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Method to set Course Name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Method to get available seats
	 * @return Seats available
	 */
	public int getSeats() {
		return seats;
	}
	
	/**
	 * Method to set available seats
	 * @param seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	/**
	 * Method to get Professor ID of the professor teaching the course
	 * @return Professor ID
	 */
	public String getCourseProf() {
		return courseProf;
	}
	
	/**
	 * Method to set Professor ID of the professor teaching the course
	 * @param courseProf
	 */
	public void setCourseProf(String courseProf) {
		this.courseProf = courseProf;
	}
	
	public boolean isCourseFull() {
		return enrolledStudents.size() >= seats;
	}
	
	public String getSemesterID() {
		return this.semesterID;
	}
	
	public void setSemesterID(String semesterID) {
		this.semesterID=semesterID;
	}
	
	/**
	 * Method to add a student to the course
	 * @param student: the student to be added
	 * @return true if the student was added successfully, false if the course is full
	 */
	public boolean addStudent(String studentID) {
		if (!isCourseFull()) {
			return enrolledStudents.add(studentID);
		}
		return false; // Course is full
	}
	

	public void setPrice(float price) {
		this.price=price;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public Set<String> getStudents(){
		return enrolledStudents;
	}
}
