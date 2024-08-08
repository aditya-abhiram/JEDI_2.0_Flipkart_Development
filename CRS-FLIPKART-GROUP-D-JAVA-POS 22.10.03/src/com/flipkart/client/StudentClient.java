package com.flipkart.client;

import com.flipkart.business.StudentOperations;

public class StudentClient {
	public static void main(String[] args) {
		StudentOperations sb1= new StudentOperations();
		sb1.addCourses("csf11", 101);
		sb1.deleteCourse("csf111", 101);
	}
	
}
