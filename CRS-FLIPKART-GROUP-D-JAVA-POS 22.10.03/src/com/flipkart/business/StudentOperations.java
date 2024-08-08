package com.flipkart.business;

public class StudentOperations {
	public boolean makePayment(int userId) {
		return true;
	}
	
	public void addCourses(String courseId,int userId) {
		System.out.println("course added successfully whose course id is "+courseId);
	}
	public void deleteCourse(String courseId,int userId) {
		System.out.println("course deleted successfully whose course id is "+courseId);
	}
	

}
