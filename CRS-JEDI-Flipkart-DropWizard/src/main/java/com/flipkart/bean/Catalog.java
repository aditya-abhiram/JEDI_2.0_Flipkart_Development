package com.flipkart.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author JEDI-03
 * Class to manage the catalog of courses
 * 
 */
public class Catalog {

    private Set<Course> courses; // Set of courses in the catalog

    /**
     * Default constructor
     */
    public Catalog() {
        this.courses = new HashSet<>();
    }

    /**
     * Method to add a course to the catalog
     * @param course: the course to add
     * @return true if the course was added successfully, false if the course already exists
     */
    public boolean addCourse(Course course) {
        return courses.add(course);
    }

    /**
     * Method to remove a course from the catalog
     * @param courseCode: the code of the course to remove
     * @return true if the course was removed successfully, false if the course was not found
     */
    public boolean removeCourse(String courseCode) {
        return courses.removeIf(course -> course.getCourseID().equals(courseCode));
    }

    /**
     * Method to get the list of courses in the catalog
     * @return set of courses
     */
    public Set<Course> getCourses() {
        return new HashSet<>(courses); // Return a copy to avoid external modification
    }
}
