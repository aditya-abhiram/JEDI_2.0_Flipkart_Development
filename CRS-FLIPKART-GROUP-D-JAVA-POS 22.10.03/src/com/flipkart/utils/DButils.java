package com.flipkart.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {
	public static Connection getConnection() {
		Connection connection = null;
		
		if(connection!=null) {
			return connection;
		}
		else {
			try {
			Properties prop = new Properties();
			InputStream inputStream = new FileInputStream("/Users/divya/eclipse-workspace/JEDI/src/config.properties");
			prop.load(inputStream);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			connection = DriverManager.getConnection(url,user,password);
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			return connection;
			
			
			
			
		}
	}
	public static void main(String args[]) {
		Connection con = getConnection();
		System.out.println(con);
	}

}
