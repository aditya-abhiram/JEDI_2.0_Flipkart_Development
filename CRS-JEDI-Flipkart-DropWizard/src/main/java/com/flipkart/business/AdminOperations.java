package com.flipkart.business;

import java.util.Set;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoServices;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.dao.AdminDaoInterface;

public class AdminOperations implements AdminInterface{
    /**
     * Method to add a professor
     * @param professor: the professor to add
     */
	AdminDaoInterface adi=new AdminDaoServices();
	
    public String addProf(Prof prof, String username) throws UserAlreadyExistsException{
		String userID;

			userID = adi.addProf(prof, username);
			if(!userID.isEmpty())return "Professor Added with id: "+userID;

    		return "Operation Failed...";
    		//userInstance.makeNew(username,(User)prof);
    }

    /**
     * Method to remove a professor
     * @param professorID: the ID of the professor to remove
     * @return true if professor was removed successfully, false otherwise
     * @throws UserNotFoundException 
     */
    public String removeProf(String profID) throws UserNotFoundException {
    	//prof.setRole("user");

			if(adi.removeProf(profID))return "Professor removed successfully";
		
    	return "Operation Failed..."; // Professor ID not found
    }

    /**
     * Method to update a course
     * @param courseCode: the code of the course to update
     * @param updatedCourse: the updated course details
     * @return true if course was updated successfully, false otherwise
     * @throws CourseNotFoundException 
     * @throws CourseAlreadyExistsException 
     */
    public String updateCourse(String courseID, Course updatedCourse) throws CourseAlreadyExistsException, CourseNotFoundException {
        //catalog.removeCourse(courseCode);
        //catalog.addCourse(updatedCourse);
			if(adi.updateCourse(courseID, updatedCourse))return "Course information updated successfully";
		
    	return "Operation Failed...";
    }

    /**
     * Method to add a course
     * @param course: the course to add
     * @throws CourseAlreadyExistsException 
     */
    public String addCourse(Course course) throws CourseAlreadyExistsException {
    	//

			if(adi.addCourse(course))return "Course added Successfully";
		
    	return "Operation Failed...";
    }

    /**
     * Method to remove a course
     * @param courseCode: the code of the course to remove
     * @return true if course was removed successfully, false otherwise
     * @throws CourseNotFoundException 
     */
    public String removeCourse(String courseID) throws CourseNotFoundException {

			if(adi.removeCourse(courseID))return "Course removed Successfully";
		
    	return "Operation Failed...";
    }

    /**
     * Method to register a student
     * @param student: the student to register
     * @throws UserNotFoundException 
     */
    public String registerStudent(String studentID) throws UserNotFoundException {

			if(adi.registerStudent(studentID))return "Student approved";
    	return "Operation Failed...";
    	//student.setApproved(true);
    }

	@Override
	public String viewCourses() {
		// TODO Auto-generated method stub
		Set<Course> courses = adi.viewCourses();
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
	public String viewProfessors() {
		// TODO Auto-generated method stub
        Set<Prof> profs = adi.viewProfessors();
        StringBuilder catalog = new StringBuilder();
        profs.forEach(prof -> 
            catalog.append(prof.getName()).append("\t\t")
                   .append(prof.getID()).append("\t\t")
                   .append(prof.getDept()).append("\n")
        );
        return catalog.toString().trim(); 
	}

	@Override
	public String viewUnapprovedStudents() {
		// TODO Auto-generated method stub
		Set<Student> studentList = adi.viewUnapprovedStudents();
        StringBuilder students = new StringBuilder();
        studentList.forEach(student -> 
            students.append(student.getID()).append("\t\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim();
	}
}
