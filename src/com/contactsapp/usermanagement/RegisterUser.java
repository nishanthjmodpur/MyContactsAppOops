package com.contactsapp.usermanagement;

import com.contactsapp.invalidinputexception.InvalidInputException;

/**
 * This class is responsible for registering a new user
 */

public class RegisterUser {
	public static User registerUser(String name, String email, String password, String phone, UserType userType) throws InvalidInputException {
		EmailValidator emailValidator = new EmailValidator();
		PasswordValidator passwordValidator = new PasswordValidator();
		
		String validatedEmail = emailValidator.validateEmail(email);
		String validatedPassword = passwordValidator.validatePassword(password);
		String hashedPassword = passwordValidator.hashPassword(validatedPassword);
		return new User(name, validatedEmail, hashedPassword, phone, userType);
	}
}
