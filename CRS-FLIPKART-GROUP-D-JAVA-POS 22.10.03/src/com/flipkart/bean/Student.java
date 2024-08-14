package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private int batch;
	private String branch;
	boolean isPaymentdone;
	boolean isRegistrationdone;

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

	public boolean isPaymentdone() {
		return isPaymentdone;
	}

	public void setPaymentdone(boolean isPaymentdone) {
		this.isPaymentdone = isPaymentdone;
	}

	public boolean isRegistrationdone() {
		return isRegistrationdone;
	}

	public void setRegistrationdone(boolean isRegistrationdone) {
		this.isRegistrationdone = isRegistrationdone;
	}

	public Student(int userId, String name,String role, String password, String username,int batch,String branch, boolean isIspaymentdone,boolean isRegistrationdone)
    {
		super(userId, name, role, password, username);
		this.batch=batch;
		this.branch=branch;
		this.isPaymentdone = isIspaymentdone;
		this.isRegistrationdone=isRegistrationdone;
    }
	
	
	

	
}
