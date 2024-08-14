package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.flipkart.client.AdminClient;
import com.flipkart.client.ProfessorClient;
import com.flipkart.client.StudentCRSMenu;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.RoleNotFoundException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DButils;

public class UserDaoOperations implements UserDaoInterface {

    @Override
    public void signup(int userId, String password, String role) throws RoleNotFoundException, UserIdAlreadyInUseException {
        // Register a new user and handle their role-specific data
        try (
            Connection con = DButils.getConnection()
        ) {
            String userQuery = "INSERT INTO user (userId, password, role) VALUES (?, ?, ?)";
            try (PreparedStatement userStmt = con.prepareStatement(userQuery)) {
                userStmt.setInt(1, userId);
                userStmt.setString(2, password);
                userStmt.setString(3, role);
                userStmt.executeUpdate();
            }

            if (role.equals("student")) {
                System.out.println("---------------Student Registration----------------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("What's your batch");
                int batch = sc.nextInt();
                System.out.println("What's your branch");
                String branch = sc.next();
                
                String studentQuery = "INSERT INTO student (studentId, batch, branch, isApproved) VALUES (?, ?, ?, ?)";
                try (PreparedStatement studentStmt = con.prepareStatement(studentQuery)) {
                    studentStmt.setInt(1, userId);
                    studentStmt.setInt(2, batch);
                    studentStmt.setString(3, branch);
                    studentStmt.setInt(4, 0); // default is not approved
                    studentStmt.executeUpdate();
                }
            } else if (role.equals("professor")) {
                Scanner sc = new Scanner(System.in);
                System.out.println("What's your department");
                String department = sc.next();
                
                String professorQuery = "INSERT INTO professor (professorId, department) VALUES (?, ?)";
                try (PreparedStatement professorStmt = con.prepareStatement(professorQuery)) {
                    professorStmt.setInt(1, userId);
                    professorStmt.setString(2, department);
                    professorStmt.executeUpdate();
                }
            } else {
                throw new RoleNotFoundException("Role is not found");
            }
            System.out.println("Successfully registered");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new UserIdAlreadyInUseException("User ID already exists. Please choose a different ID.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't register");
        }
    }

    @Override
    public void login(int userId, String password) throws UserNotFoundException, CourseNotAddedException, CourseNotFoundException, StudentNotApprovedException, StudentNotFoundException, ProfessorNotAddedException {
        // Authenticate user and redirect to appropriate menu based on role
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE userId = ? AND password = ?")
        ) {
            stmt.setInt(1, userId);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    System.out.println("Login successful. Welcome, user with ID: " + userId + ". Your role is " + role);
                    System.out.println("-------------------------------------------------------------");
                    
                    Date currentDate = new Date();
                    System.out.println("Date :" + currentDate);
                    
                    if (role.equals("student")) {
                        boolean isApproved = false;

                        try (
                            PreparedStatement stmt1 = con.prepareStatement("SELECT isApproved FROM student WHERE studentId = ?")
                        ) {
                            stmt1.setInt(1, userId);

                            try (ResultSet rs1 = stmt1.executeQuery()) {
                                if (rs1.next()) {
                                    isApproved = rs1.getBoolean("isApproved");
                                }
                            }
                        } catch (SQLException e) {
                            System.out.println("Error fetching student approval status: " + e.getMessage());
                        }

                        if (isApproved) {
                            System.out.println("Student is approved by admin");
                            StudentCRSMenu studentMenu = new StudentCRSMenu();
                            studentMenu.createStudentMenu(userId);
                        } else {
                            System.out.println("Student is not approved by admin");
                        }
                    } else if (role.equals("admin")) {
                        AdminClient adminMenu = new AdminClient();
                        adminMenu.createAdminMenu(userId);
                    } else if (role.equals("professor")) {
                        ProfessorClient professorMenu = new ProfessorClient();
                        professorMenu.createProfessorMenu(userId);
                    } else {
                        System.out.println("Role not defined");
                    }
                } else {
                    System.out.println("Invalid userId or password. Please try again.");
                    throw new UserNotFoundException("Invalid userId or password. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
            System.out.println("Couldn't log in");
        }
    }
}
