package com.flipkart.dao;

public interface StudentDAOInterface {

    public void login(int userId, String password) {
	    try {
	        // Establishing connection
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Testing", "root", "123456");
	        
	        
	        String query = "SELECT * FROM user WHERE userId = ? AND password = ?";
	        PreparedStatement stmt = con.prepareStatement(query);
	        
	       
	        stmt.setInt(1, userId);         
	        stmt.setString(2, password);    
	        
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        
	        if (rs.next()) {
	            System.out.println("Login successful. Welcome, user with ID: " + userId);
	            
	            String role = rs.getString("role");
	            System.out.println("Your role is: " + role);
	            System.out.println(role.getClass().getName());
	            System.out.println("hfuf".getClass().getName());
	            
	            
	            if(role.equals("student")) {
	            	StudentCRSMenu studentMenu = new StudentCRSMenu();
	            	studentMenu.createStudentMenu(userId);
	            }
	            else if(role.equals("admin")) {
	            	AdminClient adminMenu = new AdminClient();
	            	adminMenu.createAdminMenu(userId);
	            	
	            }
	            else if(role.equals("professor")) {
	            	ProfessorClient professorMenu = new ProfessorClient();
	            	professorMenu.createProfessorMenu(userId);
	            	
	            	
	            }
	            else {
	            	System.out.println("role not defined");
	            }
	        } else {
	            System.out.println("Invalid userId or password. Please try again.");
	        }
	        
	       
	        rs.close();
	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        System.out.println(e);
	        System.out.println("Couldn't log in");
	    }
	}

}
