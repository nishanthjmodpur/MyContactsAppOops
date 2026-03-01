package com.contactsapp.usermanagement;

import java.util.HashMap;

import com.contactsapp.invalidinputexception.InvalidInputException;

/**
 * This class is responsible for registering a new user
 */

public class RegisterUser {
	private HashMap<String, User> users = new HashMap<String, User>();
	
	public User registerUser(String name, String email, String password, String phone, UserType userType) throws InvalidInputException {
		EmailValidator emailValidator = new EmailValidator();
		PasswordValidator passwordValidator = new PasswordValidator();
		
		String validatedEmail = emailValidator.validateEmail(email);
		String validatedPassword = passwordValidator.validatePassword(password);
		String hashedPassword = passwordValidator.hashPassword(validatedPassword);
		User user = new User(name, validatedEmail, hashedPassword, phone, userType);
		
		users.put(validatedEmail, user);
		return user;
	}
	
	public HashMap<String, User> getUsers() {
		return users;
	}
}
