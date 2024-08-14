package com.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception {
	
	 public UserIdAlreadyInUseException() {
	        
	  }

   
   public UserIdAlreadyInUseException(String message) {
       super(message);  
   }

}
