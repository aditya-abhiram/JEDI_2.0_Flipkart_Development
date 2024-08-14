package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //jdbc:mysql://localhost:3306/?user=root
    //root@localhost:3306
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/Testing";
    private static final String USER = "root";
    private static final String PASSWORD = "Mydad$$24";

   
    public static Connection getConnection() {
        Connection con = null;
        try {
           
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return con;
    }

    
    public static void main(String[] args) {
        Connection con = getConnection();
        if (con != null) {
            System.out.println("Connection established successfully.");
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
