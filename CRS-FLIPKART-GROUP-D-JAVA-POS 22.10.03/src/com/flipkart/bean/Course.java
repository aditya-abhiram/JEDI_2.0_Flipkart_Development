package com.flipkart.bean;

public class Course {
	private int courseId;
	private String courseName;
	private int instructorId;
	private String instructorName;
	private int filledSeats;
	private int credit;
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
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	

}
