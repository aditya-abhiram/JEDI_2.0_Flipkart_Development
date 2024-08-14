package com.flipkart.business;

import com.flipkart.dao.ProfessorDaoOperations;

public class ProfessorOperations implements ProfessorInterface {

	@Override
	public void viewCourses(int professorId) {
		ProfessorDaoOperations professorDao = new ProfessorDaoOperations();
		professorDao.viewCourses(professorId);
		
	}

	@Override
	public void viewStudents(int professorId) {
		ProfessorDaoOperations professorDao = new ProfessorDaoOperations();
		professorDao.viewStudents(professorId);
		
	}

	@Override
	public void gradeStudent(int professorId, int studentId, int courseId) {
		ProfessorDaoOperations professorDao = new ProfessorDaoOperations();
		professorDao.gradeStudent(professorId, studentId, courseId);
		
	}

	


}
