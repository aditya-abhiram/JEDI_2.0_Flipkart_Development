package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

public class Admin extends User {

    private Map<String, Prof> professors; // Map of professor ID to Professor object
    private Map<String, Course> courses; // Map of course code to Course object
    private Map<String, Student> students; // Map of student ID to Student object
    
    /**
     * Parameterized constructor
     * @param ID: the admin ID
     * @param name: the admin's name
     * @param contact: the admin's contact information
     * @param email: the admin's email
     */
    public Admin(String ID, String name, String contact, String email, String password) {
        super(ID, name, "Admin", contact, email, password);
        this.professors = new HashMap<>();
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
    }
    
    //@Override
    public void update() {
        // Code to update admin information
    }
    
    //@Override
    public void changePassword(String password) {
        // Code to change admin password
    	super.setPassword(password);
    }
}
