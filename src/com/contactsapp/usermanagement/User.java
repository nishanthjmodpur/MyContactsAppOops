package com.contactsapp.usermanagement;

/**
 * This class defines the blueprint of an User object.
 */

public class User {
	private static int nextId = 1;
	
	private int userId;
	private String name;
	private String email;
	private String hashedPassword;
	private String phoneNumber;
	private UserType userType;
	
	public User(String name, String email, String password, String phoneNumber, UserType userType) {
		this.userId = nextId++;
		this.name = name;
		this.email = email;
		this.hashedPassword = password;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
	}
	
	
	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getUserType() {
		return userType.toString();
	}
	
}
