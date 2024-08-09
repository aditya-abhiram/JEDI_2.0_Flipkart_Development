package com.flipkart.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Student;
import com.flipkart.bean.Course;

public class StudentOperations {
	List<Student> students= new ArrayList<Student>();
	HashMap<Integer, List<String> > map = new HashMap<>();
	public void createStudent() {
		Student s1= new Student();
		s1.setBatch(2020);
		s1.setBranch("cs");
		s1.setName("john");
		List<String> courses = new ArrayList<String>();
		courses.add("oops");
		courses.add("dsa");
		s1.setCourses(courses);
		
		List<String> courses2 = new ArrayList<String>();
		courses2.add("oops");
		courses2.add("dsa");
		s1.setCourses(courses2);
		Student s2= new Student();
		s1.setBatch(2020);
		s1.setBranch("ece");
		s1.setName("max");
		
		students.add(s1);
		students.add(s2);
		
		
	}
	

	
	
	public boolean makePayment(int userId) {
		return true;
	}
	
	public void addCourse(String courseId,int userId) {
		System.out.println("course added successfully whose course id is "+courseId);
		courseids.add(courseId);
		map.put(userId,courseids);
		
		
	}
	public void deleteCourse(String courseId,int userId) {
		System.out.println("course deleted successfully whose course id is "+courseId);
	}
	

}
