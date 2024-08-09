package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private int batch;
	private String branch;
	private List<String> courses = new ArrayList<String>();
	
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	

	
}
