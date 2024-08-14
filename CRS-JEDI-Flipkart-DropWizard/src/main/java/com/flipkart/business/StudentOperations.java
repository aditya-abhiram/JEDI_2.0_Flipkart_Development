package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoServices;
import com.flipkart.exception.BillingNotFoundException;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentOperations implements StudentInterface {
	StudentDaoInterface sdi=new StudentDaoServices();
    /**
     * Method to register the student in a course
     * @param course: the course to register
     * @return true if registration was successful, false otherwise
     * @throws CourseNotFoundException 
     * @throws CourseNotAvailableException 
     * @throws CourseAlreadyOptedException 
     */
	public String register(Student student, List<String> courses) throws CourseAlreadyOptedException, CourseNotAvailableException, CourseNotFoundException {
		String confirmedRegistration="";
		int count=0;
		float price=0;
		for(String courseID:courses) {
			if(count==4)break;
			float temp=0;
			temp = sdi.register(student, courseID);
			
			count++;
			confirmedRegistration=confirmedRegistration.concat(courseID+"\n");
			price+=temp;
			
		}
		return confirmedRegistration.concat("price: " + String.valueOf(price));
	}
    
    /**
     * Method to view courses registered by the student
     * @return list of registered courses
     */
	
    public String viewCoursesEnrolled(Student student) {
        //return student.courseList();
    	StringBuilder courses = new StringBuilder();
	    List<Course> courseList = sdi.viewCoursesEnrolled(student);
	    
	    courseList.forEach(course -> 
	        courses.append(course.getCourseID()).append("\t")
	               .append(course.getCourseName()).append("\t")
	               .append(course.getCourseProf()).append("\n")
	    );

	    return courses.toString();
    }
    
    /**
     * Method to get a report of registered courses
     * @return a string report of registered courses
     */
    public String getReport(Student student) {
        //return student.getReport();
    	StringBuilder report = new StringBuilder();
        ReportCard reportCard = sdi.getReport(student);
        
        reportCard.getGrades().forEach((key, value) -> 
            report.append(key).append(":").append(value).append("\n")
        );

        return report.toString();
    }
    
    /**
     * Method to get billing information
     * @return billing information
     * @throws BillingNotFoundException 
     */
    public String getBillingInfo(Student student) throws BillingNotFoundException {
        
    	Billing billing;
		billing = sdi.getBillingInfo(student);
    	String status="Pending";
    	if(billing.isStatus())status="Completed";
    	return billing.getBillingID()+"\t"+billing.getBillamt()+"\t"+status;
		
    }

	@Override
	public int getValidCount(List<String> courses) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String viewCourses() {
		// TODO Auto-generated method stub
		StringBuilder catalog = new StringBuilder();
	    Set<Course> courses = sdi.viewCourses();
	    
	    courses.forEach(course -> {
	        String prof = course.getCourseProf();
	        if (prof == null) prof = "Prof Awaited";
	        catalog.append(course.getCourseID()).append("\t")
	               .append(course.getCourseName()).append("\t\t")
	               .append(prof).append("\t\t")
	               .append(course.getSeats()).append("\n");
	    });

	    return catalog.toString();
	}
	
	@Override
	public String makePayment(Student student, float amount, String transactionID) throws BillingNotFoundException {
	    // Retrieve billing information using the Student object
	    Billing billing;
		
		billing = sdi.getBillingInfo(student);
		if (billing.isStatus()) {
	        return "Payment already completed for billing ID: " + billing.getBillingID();
	    }

	    // Generate a unique transaction ID
	    billing.setTransactionID(transactionID);
	    billing.setBillamt(amount);

	    // Update billing information in the database
	    boolean paymentSuccess = sdi.updateBillingInfo(billing);
	    
	    if (paymentSuccess) {
	        return "Payment Successful. Transaction ID: " + transactionID;
	    } else {
	        return "Payment failed. Please try again.";
	    }
	    
	}

	@Override
	public float getCoursePricing(Student student) {
		// TODO Auto-generated method stub
		float price=0;
    	List<Course> courseList=sdi.viewCoursesEnrolled(student);
    	for(Course course:courseList) {
    		price+=course.getPrice();
    	}
    	return price;
	}
}


