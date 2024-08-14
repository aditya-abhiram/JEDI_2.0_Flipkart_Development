package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.ProfDaoInterface;
import com.flipkart.dao.ProfDaoServices;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.GradeAlreadyAddedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class ProfOperations implements ProfInterface{
	ProfDaoInterface pdi = new ProfDaoServices();
    /**
     * Method to offer a course
     * @param course: the course to be offered
     * @throws CourseNotAvailableException 
     */
    public String offerCourse(String courseID, Prof prof) throws CourseNotAvailableException {
        
		if(pdi.offerCourse(courseID, prof))return "Course enrolled successfully";
		
        return "Enrollment failed...";
        //
    }

    /**
     * Method to get the registered students for a given course
     * @param course: the course for which to get the registered students
     * @return set of registered students
     */
    public String getStudents(String courseID, Prof prof) {
    	//return prof.getRegisteredStudents(courseID);
    	Set<Student> studentList = pdi.getStudents(courseID, prof);
        StringBuilder students = new StringBuilder();
        studentList.forEach(student -> 
            students.append(student.getID()).append("\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim(); 
    }

    /**
     * Method to give a grade to a student in a course
     * @param course: the course in which the grade is to be given
     * @param student: the student to whom the grade is to be given
     * @param grade: the grade to be given
     * @return true if grade was successfully assigned, false otherwise
     * @throws CourseNotOfferedException 
     * @throws GradeAlreadyAddedException 
     * @throws CourseNotOptedException 
     */
    public String giveGrade(String courseID, String studentID, String grade, Prof prof) throws CourseNotOptedException, GradeAlreadyAddedException, CourseNotOfferedException {
         // Student is not registered for the course
    	//Set<Student> studentList=prof.getRegisteredStudents(courseID);
    	
    	/*for(Student stu:studentList) {
    		if(stu.getID().equals(studentID)) {
    			stu.updateGrade(courseID, grade);
    			return true;
    		}
    	}*/
		if(pdi.giveGrade(courseID, studentID, grade, prof))return "Grade submitted successfully";
		
    	return "Grade submission failed...";
    }
    
    @Override
	public String viewCourses() {
		// TODO Auto-generated method stub
    	Set<Course> courses = pdi.viewCourses();
        StringBuilder catalog = new StringBuilder();
        courses.forEach(course -> {
            String prof = course.getCourseProf();
            if (prof == null) prof = "Prof Awaited";
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\t\t")
                   .append(prof).append("\t\t")
                   .append(course.getSeats()).append("\n");
        });
        return catalog.toString().trim();
	}

	@Override
	public String viewCourseOffering(Prof prof) {
		// TODO Auto-generated method stub
		Set<Course> courses = pdi.viewCourseOffering(prof);
        StringBuilder catalog = new StringBuilder();
        courses.forEach(course -> 
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\n")
        );
        return catalog.toString().trim();
	}
}
