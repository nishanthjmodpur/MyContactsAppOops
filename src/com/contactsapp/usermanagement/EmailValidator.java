package com.contactsapp.usermanagement;

import java.util.regex.Pattern;

import com.contactsapp.invalidinputexception.InvalidInputException;

/**
 * UC1: This class is responsible for validating the user entered email:
 * 		- it checks if the email format is correct by matching it against the regex.
 */

public class EmailValidator {
	public String validateEmail(String email) throws InvalidInputException {
		if (!Pattern.matches("[A-Za-z0-9+_.-]+@(.+)$", email)) {
			throw new InvalidInputException("Invalid email format");
		}
		return email.trim().toLowerCase();
	}
}
