package com.flipkart.bean;

/**
 * 
 * @author JEDI-03
 * Class to store billing information
 * 
 */
public class Billing {

    private String billingID;
    private String studentID;
    private float billamt;
    private boolean status; // true for paid, false for unpaid
    private String transactionID;

    /**
     * Parameterized constructor
     * @param billingID: unique billing identifier
     * @param studentID: ID of the student
     * @param billamt: amount to be billed
     * @param status: payment status
     */
    public Billing(String billingID, String studentID, float billamt, boolean status) {
        this.billingID = billingID;
        this.studentID = studentID;
        this.billamt = billamt;
        this.status = status;
        this.setTransactionID(null);
    }

    // Getters and Setters
    public String getBillingID() {
        return billingID;
    }

    public void setBillingID(String billingID) {
        this.billingID = billingID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public float getBillamt() {
        return billamt;
    }

    public void setBillamt(float billamt) {
        this.billamt = billamt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
}
