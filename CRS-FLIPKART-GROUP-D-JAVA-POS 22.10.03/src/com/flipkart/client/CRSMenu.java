package com.flipkart.client;

import java.util.Scanner;

public class CRSMenu {
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to crs Application");
			System.out.println("Press 1: Login");
	        System.out.println("Press 2: Registration of the Student");
	        System.out.println("Press 3: Update Password");
	        System.out.println("Press 4: Exit");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	            	System.out.println("Enter the user name");
	            	String username = scanner.next();
	            	System.out.println("Enter the password");
	            	String password = scanner.next();
	            	System.out.println("Enter role");
	            	String role = scanner.next().toLowerCase();
	            	if(role.contentEquals("admin")) {
	            		;
	            	}
	            	else if(role.contentEquals("professor")) {
	            		;
	            	}
	            	else if(role.contentEquals("student")) {
	            		;
	            	}
	            	
	                break;
	            case 2:
	                ;
	                break;
	            case 3:
	                ;
	                break;
	            case 4:
	                System.out.println("Exiting...");
	                return;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	        
		}
	}
}
