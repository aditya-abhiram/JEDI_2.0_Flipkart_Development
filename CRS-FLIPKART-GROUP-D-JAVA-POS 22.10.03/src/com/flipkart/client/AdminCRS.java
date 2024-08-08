package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import java.util.Scanner;

public class AdminCRS {
		Scanner in = new Scanner(System.in);
		
		public void RunadminActivity() {
		System.out.println("Welcome to Admin Activity");
		System.out.println("1.Authenticate Student");
		System.out.println("2.Update Course List");
		System.out.println("3.Add Professor");
		System.out.println("4.Remove Professor");
		System.out.println("5.Generate Grade Sheet");
		System.out.println("6.Logout");
		int adminactivity = in.nextInt();in.nextLine();
		switch(adminactivity) {
			case 1:
				AuthenticateStudentRegistration();
				break;
			case 2:
				UpdateCourseList();
				break;
			case 3:
				AddProfessor();
				break;
			case 4:
				RemoveProfessor();
				break;
			case 5:
				GenerateGradeSheet();
				break;
				
			}
		}
		
		private void AuthenticateStudentRegistration() {
			System.out.println("Student Authentication Complete");
		}
		
		private void UpdateCourseList() {
			System.out.println("Courses Updated");
		}
		
		private void AddProfessor() {
			System.out.println("Professor added");
		}
		
		private void RemoveProfessor() {
			System.out.println("Professor removed");
		}
		
		private void GenerateGradeSheet() {
			System.out.println("Grade Sheet generated");
		}
		
}
