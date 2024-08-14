package com.flipkart.bean;

public class User {
	private int userId;
	private String name;
	private String role;
	private String username;
	private String password;
	
	public User(int userId, String name, String role, String password, String username) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
