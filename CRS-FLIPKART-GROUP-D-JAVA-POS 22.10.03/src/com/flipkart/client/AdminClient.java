package com.flipkart.client;

import com.flipkart.business.AdminOperations;

public class AdminClient {
	public static void main(String[] args) {
		AdminOperations ab1= new AdminOperations();
		ab1.addCourse("csf111");
		ab1.addProfessor(100);
		ab1.deleteProfessor(102);
		ab1.approveStudent(101);
		ab1.removeCourse("csf111");
	}

}
