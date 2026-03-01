package com.contactsapp.usermanagement;

import java.util.HashMap;

public interface Authentication {
	boolean login(String email, String passwordHash, HashMap<String, User> users);
}
