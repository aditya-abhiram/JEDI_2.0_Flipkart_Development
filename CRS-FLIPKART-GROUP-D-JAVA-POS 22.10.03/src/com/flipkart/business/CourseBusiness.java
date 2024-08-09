package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;

public class CourseBusiness {

    List<Course> courses =new ArrayList<>();
    public void createCourse() {
        Course c1=new Course();
        Course c2=new Course();
        c1.setCourseId(101);
        c1.setCourseName("Intro to Java");
        c1.setFilledSeats(0);
        c1.setInstructorId("J01");
        c1.setInstructorName("Shailja S");
        c2.setCourseId(102);
        c2.setCourseName("Intro to Python");
        c2.setFilledSeats(0);
        c2.setInstructorId("P01");
        c2.setInstructorName("Sahiti S");
    }
    
}
