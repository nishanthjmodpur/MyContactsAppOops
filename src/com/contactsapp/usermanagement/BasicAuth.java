package com.contactsapp.usermanagement;

import java.util.HashMap;

/**
 * UC2 - User Authentication and Session management
 * This class implements the basic authentication logic.
 * It checks if the user is already registered. If user is found then
 * verifies login details provided and returns a boolean to authenticate the user.
 */

public class BasicAuth implements Authentication {
	PasswordValidator passwordValidator = new PasswordValidator();
	
	@Override
	public boolean login(String email, String passwordHash, HashMap<String, User> users) {
		if (users.containsKey(email)) {
			User user = users.get(email);
			if (user.getPasswordHash().equals(passwordValidator.hashPassword(passwordHash))) {
				return true;
			}
		}
		return false;
	}
}
