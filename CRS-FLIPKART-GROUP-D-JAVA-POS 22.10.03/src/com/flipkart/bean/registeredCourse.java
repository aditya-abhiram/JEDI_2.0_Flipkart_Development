package com.flipkart.bean;

public class RegisteredCourse {
	private int studentId;
	private int courseId;
	private String registeredCoursename;
	private String grade;
	private int credit;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getRegisteredCoursename() {
		return registeredCoursename;
	}
	public void setRegisteredCoursename(String registeredCoursename) {
		this.registeredCoursename = registeredCoursename;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	

}
