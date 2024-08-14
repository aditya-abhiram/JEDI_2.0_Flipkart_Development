package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
private static Connection connection = null;
	
	public static Connection getConnection() {
		
        if (connection != null)
            return connection;
        else {
            try {
            	// Properties prop = new Properties();
                // InputStream inputStream = new FileInputStream("/Users/aditya.a1/Desktop/abhiram/JEDI3.0_Flipkart_Development_GE/CRS-JEDI-Flipkart-DropWizard/src/main/java/config.properties");
                // prop.load(inputStream);
                // String driver = prop.getProperty("driver");
                // String url = prop.getProperty("url");
                // String user = prop.getProperty("user");
                // String password = prop.getProperty("password");
                // Class.forName(driver);
                String url = "jdbc:mysql://localhost:3306/?user=root";
                String user = "root";
                String password = "Mydad$$24";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            //catch (IOException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// } catch (ClassNotFoundException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// } 
            return connection;
        }
	}
	
	public static boolean closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } 
        catch (SQLException se) {
        	return false;
        }
        return true;
	}
}
