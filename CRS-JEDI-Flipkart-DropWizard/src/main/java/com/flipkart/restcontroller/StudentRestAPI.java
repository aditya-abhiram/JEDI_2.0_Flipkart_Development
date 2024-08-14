package com.flipkart.restcontroller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperations;

@Path("/student")
public class StudentRestAPI {
	StudentInterface studentService = new StudentOperations();
	
	@GET
    @Path("/welcome/{username}")
    public Response welcome(@PathParam("username") String username) {
        String message = "This is CRS Application Welcome " + username + "\nLOGIN TIME: " + LocalDateTime.now();
        return Response.ok(message).build();
    }

	@GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewCourses() {
        try {
            String courseList = studentService.viewCourses();
            return Response.ok(courseList).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Something went wrong").build();
        }
    }
	
	/**
	jdbc:mysql://localhost:3306/?user=root * Endpoint for add course to opted courses list
	 * 
	 * @param course
	 * @return 201, if course is opted successfully, else 500
	 */
	@POST
    @Path("/addCourse/{courseList}")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(@NotNull Student student,@PathParam("courseList") String courseList) {
        try {
        	List<String> courses = Arrays.stream(courseList.split("\\s+")) // Split by any whitespace
                    .map(String::trim) // Trim whitespace
                    .filter(s -> !s.isEmpty()) // Filter out empty strings
                    .collect(Collectors.toList());
        	String status=studentService.register(student,courses);
        	return Response.status(201).entity(status).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
	
	
	/**
	 * Endpoint for view opted courses
	 * 
	 * @return 201, and list of courses if user logged in, else 500 in case of error
	 */
	@GET
    @Path("/viewOptedCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewOptedCourses(@NotNull Student student) {
        try {
            String courseList = studentService.viewCoursesEnrolled(student);
            return Response.ok(courseList).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
	
	
	/**
	 * Endpoint for view Registered courses
	 * 
	 * @return 201, and list of courses if user logged in, else 500 in case of error
	 */
	@GET
    @Path("/viewRegisteredCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewRegisteredCourses(@NotNull Student student) {
		try {
            String courseList = studentService.viewCoursesEnrolled(student);
            return Response.ok(courseList).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
	
	/**
	 * Endpoint for getting total fee
	 * 
	 * @return 201, and total fee if user is logged in, else 500 in case of error
	 */
	@GET
    @Path("/getTotalFee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalFee(@NotNull Student student){
        
        try {
        	String fee = studentService.getBillingInfo(student);
            return Response.status(201).entity(fee).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
	
	/**
	 * Endpoint for Make payment
	 * 
	 * @param payment
	 * @return 201, if payment is successful, else 500 in case of error
	 */
	@POST
    @Path("/makePayment/{transactionID}/{amount}")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response makePayment(@NotNull Student student, @PathParam("transactionID") String transactionID, @PathParam("amount") float amount) {
        try {
        	String status = studentService.makePayment(student,amount,transactionID);
            return Response.status(201).entity(status).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
	
	/**
	 * Endpoint for viewing grade card
	 * 
	 * @return 201, and gradeCard if user is logged in, else 500 in case of error
	 */
	@GET
    @Path("/gradeCard")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGradeCard(@NotNull Student student) {
        try {
        	String gradeCard = studentService.getReport(student);
        	return Response.ok(gradeCard).build();
        } catch (Exception e) {
        	return Response.status(500).entity("Error : "+e.getMessage()).build();
        }
    }
}
