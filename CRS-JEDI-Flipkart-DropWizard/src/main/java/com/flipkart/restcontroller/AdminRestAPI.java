package com.flipkart.restcontroller;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.business.*;
import com.flipkart.exception.*;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminRestAPI {
    private final AdminInterface adminService = new AdminOperations();

    @GET
    @Path("/welcome/{username}")
    public Response welcome(@PathParam("username") String username) {
        String message = "Welcome to CRS Application " + username + "\nLOGIN TIME: " + LocalDateTime.now();
        return Response.ok(message).build();
    }

    @POST
    @Path("/addProfessor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfessor(Prof prof) {
        try {
            String result = adminService.addProf(prof, prof.getName());
            return Response.ok(result).build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/removeProfessor/{profID}")
    public Response removeProfessor(@PathParam("profID") String profID) {
        try {
            String result = adminService.removeProf(profID);
            return Response.ok(result).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) {
        try {
            String result = adminService.addCourse(course);
            return Response.ok(result).build();
        } catch (CourseAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/updateCourse/{oldCourseID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCourse(@PathParam("oldCourseID") String oldCourseID, Course course) {
        try {
            String result = adminService.updateCourse(oldCourseID, course);
            return Response.ok(result).build();
        } catch (CourseNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (CourseAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/removeCourse/{courseID}")
    public Response removeCourse(@PathParam("courseID") String courseID) {
        try {
            String result = adminService.removeCourse(courseID);
            return Response.ok(result).build();
        } catch (CourseNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/unapprovedStudents")
    public Response viewUnapprovedStudents() {
        return Response.ok(adminService.viewUnapprovedStudents()).build();
    }

    @POST
    @Path("/approveRegistration/{studentID}")
    public Response approveRegistration(@PathParam("studentID") String studentID) {
        try {
            String result = adminService.registerStudent(studentID);
            return Response.ok(result).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}