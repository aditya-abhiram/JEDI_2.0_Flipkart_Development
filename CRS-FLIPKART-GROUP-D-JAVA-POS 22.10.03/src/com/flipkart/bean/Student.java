package com.flipkart.bean;


public class Student extends User {
	private int batch;
	private String branch;

	
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
	

	
}
