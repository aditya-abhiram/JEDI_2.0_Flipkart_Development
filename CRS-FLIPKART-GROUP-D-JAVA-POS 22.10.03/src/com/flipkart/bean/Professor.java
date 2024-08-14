package com.flipkart.bean;

public class Professor extends User{
	private String department;

	public Professor(int userId, String name,String role, String password, String username,String department)
    {
		super(userId, name, role, password, username);
		this.department = department;
    }

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
