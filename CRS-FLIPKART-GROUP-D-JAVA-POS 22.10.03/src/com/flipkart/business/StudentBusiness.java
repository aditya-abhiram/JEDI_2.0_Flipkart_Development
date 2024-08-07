package com.flipkart.business;

public class StudentBusiness {
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
