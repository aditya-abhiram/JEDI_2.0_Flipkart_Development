package com.flipkart.client;

import com.flipkart.business.UserOperations;


public class UserClient {
	public static void main(String[] args) {
		UserOperations u1= new UserOperations();
		u1.CreateUser();
		u1.updatePassword(101);
	}

}
