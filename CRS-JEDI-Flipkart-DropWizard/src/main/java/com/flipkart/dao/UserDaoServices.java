package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.DBQueries;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UsernameAlreadyInUseException;

public class UserDaoServices implements UserDaoInterface{
	
	public static Connection conn = DBUtil.getConnection();
	
	@Override
	public User getUser(String username) throws UserNotFoundException, StudentNotApprovedException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_USER_USERNAME);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
	
			User user = null;
			if (rs.next()) {
				String userID=rs.getString("userID"), role=rs.getString("role"), 
						contact=rs.getString("contact"), email=rs.getString("email"), 
						name=rs.getString("name"),password=rs.getString("password");
				//user=new User(userID,name,role,contact,email,password);
				
				if(role.equals("Student")) {
					user=getStudent(userID,name,role,contact,email,password);
					if(!((Student) user).isApproved())throw new StudentNotApprovedException(userID);
				}
				else if(role.equals("Professor")) {
					user=getProfessor(userID,name,role,contact,email,password);
				}
				else if(role.equals("Admin")) {
					user=getAdmin(userID,name,role,contact,email,password);
				}
				return user;
			}
			else {
				throw new UserNotFoundException(username);
			}
		}catch(SQLException e) {
			return null;
		}
	}
	
	User getStudent(String userID, String name, String role,
			String contact, String email, String password) throws StudentNotApprovedException{
		try{
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_STUDENT_USERID);
			
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
	
			User user = null;
			if (rs.next()) {
				String branch=rs.getString("branch");
				int rollNum=rs.getInt("rollNum");
				boolean approved=rs.getBoolean("approved");
				user=(User)new Student(userID,name,contact,email,branch,rollNum,approved,password);
				if (!approved) {
					//throw new StudentNotApprovedException(userID);
					//return null;
				}
				return user;
			}else return null;
		}catch(SQLException e) {
			return null;
		}
	}
	
	User getProfessor(String userID, String name, String role,
			String contact, String email, String password) {
		try{
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_PROFESSOR_USERID);
			
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
	
			User user = null;
			if (rs.next()) {
				String department=rs.getString("department"),qualification=rs.getString("qualification");
				//int rollNum=rs.getInt("rollNum");
				//boolean approved=rs.getBoolean("approved");
				user=(User)new Prof(userID,name,contact,email,department,qualification,password);
				return user;
			}else return null;
		}catch(SQLException e) {
			return null;
		}
	}
	
	User getAdmin(String userID, String name, String role,
			String contact, String email, String password) {
		User user=(User)new Admin(userID,name,contact,email,password);
		return user;
	}

	@Override
	public String registerStudent(String username, String name, String contact, String email, String password, String branch) throws UsernameAlreadyInUseException {
		// TODO Auto-generated method stub
		try {

			PreparedStatement ps = conn.prepareStatement(DBQueries.VERIFY_USERNAME);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				throw new UsernameAlreadyInUseException(username);
			}

		}catch (SQLException e) {
			return "SQL Exception";
		}
		try {

			PreparedStatement ps = conn.prepareStatement(DBQueries.FETCH_IDS);
			ResultSet rs=ps.executeQuery();
			List<String> userIds=new ArrayList<String>();
			while(rs.next())
			{
				userIds.add(rs.getString("userID"));
			}
			Random rand = new Random();
			String userID;
			while(true)
			{
				long id = 10000000 + rand.nextInt(10000000);
				userID =  "STUDENT" + Long.toString(id);
				if(!userIds.contains(userID))
					break;
			}
			ps = conn.prepareStatement(DBQueries.FETCH_ROLLNUMS);
			rs=ps.executeQuery();
			List<Integer> rollNums=new ArrayList<Integer>();
			while(rs.next())
			{
				rollNums.add(rs.getInt("rollNum"));
			}
			int rollNum=0;
			while(true)
			{
				rollNum++;
				if(!rollNums.contains(rollNum))
					break;
			}
			ps = conn.prepareStatement(DBQueries.ADD_USER);
			ps.setString(1, userID);
			ps.setString(2, name);
			ps.setString(3, "Student");
			ps.setString(4, contact);
			ps.setString(5, email);
			ps.setString(6, password);
			ps.setString(7, username);
			ps.executeUpdate();ps = conn.prepareStatement(DBQueries.ADD_STUDENT);
			ps.setString(1, userID);
			ps.setString(2, branch);
			ps.setInt(3, rollNum);
			ps.setBoolean(4, false);
			ps.executeUpdate();
			//
			PreparedStatement ps1 = conn.prepareStatement(DBQueries.FETCH_BILLINGS);
			ResultSet rs1=ps1.executeQuery();
			List<String> billings=new ArrayList<String>();
			while(rs1.next())
			{
				billings.add(rs1.getString("billingID"));
			}
			int billing=0;
			while(true)
			{
				billing++;
				if(!billings.contains(String.valueOf(billing)))
					break;
			}
			ps1 = conn.prepareStatement(DBQueries.ADD_BILLING);
			ps1.setString(1, userID);
			ps1.setString(2, String.valueOf(billing));
			ps1.setFloat(3, 0);
			ps1.setBoolean(4, false);
			ps1.executeUpdate();
			
			return "Registration Complete! \nuserID: "+userID+"\nrollNum: "+rollNum+"\nbillingID:"+billing;
		} catch (SQLException e) {
			return "SQL Exception";
		}
	}

	@Override
	public boolean updatePassword(String username, String oldPassword, String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps1 = conn.prepareStatement(DBQueries.GET_USER_USERNAME);
			ps1.setString(1, username);
			ResultSet rs = ps1.executeQuery();
	
			User user = null;
			if (rs.next())
			{
				PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_PASSWORD);
				ps.setString(2, username);
				ps.setString(3, oldPassword);
				ps.setString(1, newPassword);
				ps.executeUpdate();
				return true;
			}else throw new UserNotFoundException(username);
		} catch (SQLException e) {
			return false;
		}
	}

}
