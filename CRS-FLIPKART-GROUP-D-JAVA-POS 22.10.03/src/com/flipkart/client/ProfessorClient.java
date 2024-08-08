package com.flipkart.client;

import com.flipkart.business.ProfessorOperations;

public class ProfessorClient {
	public static void main(String[] args) {
		ProfessorOperations pb1= new ProfessorOperations();
		pb1.addGrade("csf111",101,'A');
		pb1.viewStudents("csf111");
	}
}
