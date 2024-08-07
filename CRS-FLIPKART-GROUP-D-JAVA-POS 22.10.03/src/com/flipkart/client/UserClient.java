package com.flipkart.client;

import com.flipkart.business.UserBusiness;


public class UserClient {
	public static void main(String[] args) {
		UserBusiness u1= new UserBusiness();
		u1.CreateUser();
		u1.updatePassword(101);
	}

}
