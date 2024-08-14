package com.flipkart.client;

import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

public class UserClient {
	public static void main(String args[]) throws UserNotFoundException, RoleNotFoundException, UserIdAlreadyInUseException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException  {
		UserCRSMenu userMenu = new UserCRSMenu();
		userMenu.createUserMenu();
		
		
	}
	

}
