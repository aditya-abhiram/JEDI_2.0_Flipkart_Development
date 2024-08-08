/**
 * 
 */
package com.flipkart.client;

/**
 * 
 */
import java.util.Scanner;
public class ProfessorCRSMenu {
	public static void main(String[] args)
	{
		while(true)
		{
		System.out.println("-----------*****************----------");
		System.out.println("Welcome to Professor Menu");
		System.out.println("Press 1 --> View Enrolled Students");
		System.out.println("Press 2 --> Assign Grades");
		System.out.println("Press 3 --> View Courses");
		System.out.println("Press 4 --> LogOut");
		System.out.println("----------******************----------");
		System.out.println("Choose an option:");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		int courseId, studentId;
		switch(option)
			{
			case 1:
				System.out.println("Enter CourseId:");
				courseId=sc.nextInt();
				viewEnrolledStudents(courseId);
				break;
			case 2:
				System.out.println("Enter CourseId:");
				courseId=sc.nextInt();
				System.out.println("Enter StudentId:");
				studentId=sc.nextInt();
				assignGrades(courseId,studentId);
				break;
			case 3:
				viewCourses();
				break;
			case 4:
				System.out.println("LoggedOut Successfully!!");
				return;
			default:
				System.err.println("Select a valid Option");
			}
		}
	}
	public static void viewCourses()
	{
		System.out.println("Viewed Courses");
	}
	public static void assignGrades(int courseId, int studentId)
	{
		System.out.println("Assigned Grades to "+courseId+" for student "+studentId);
	}
	public static void viewEnrolledStudents(int courseId)
	{
		System.out.println("Viewed Enrolled Students for "+courseId);
	}
}
