package com.flipkart.client;

import com.flipkart.business.StudentBusiness;

public class StudentClient {
	public static void main(String[] args) {
		StudentBusiness sb1= new StudentBusiness();
		sb1.addCourses("csf11", 101);
		sb1.deleteCourse("csf111", 101);
	}
	
}
