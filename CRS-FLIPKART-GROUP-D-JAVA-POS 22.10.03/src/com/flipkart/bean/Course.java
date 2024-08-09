package com.flipkart.bean;

public class Course {
	private int courseId;
	private String courseName;
	private String instructorId;
	private String instructorName;
	private int filledSeats;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public int getFilledSeats() {
		return filledSeats;
	}
	public void setFilledSeats(int filledSeats) {
		this.filledSeats = filledSeats;
	}

}
