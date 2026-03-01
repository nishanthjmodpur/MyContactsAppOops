package com.contactsapp.usermanagement;

import java.util.HashMap;

/**
 * This interface defines the methods needed to be implemented by authenticators.
 */

public interface Authentication {
	boolean login(String email, String passwordHash, HashMap<String, User> users);
}
