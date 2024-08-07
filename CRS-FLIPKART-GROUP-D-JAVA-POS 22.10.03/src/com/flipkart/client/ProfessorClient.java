package com.flipkart.client;

import com.flipkart.business.ProfessorBusiness;

public class ProfessorClient {
	public static void main(String[] args) {
		ProfessorBusiness pb1= new ProfessorBusiness();
		pb1.addGrade("csf111",101,'A');
		pb1.viewStudents("csf111");
	}
}
