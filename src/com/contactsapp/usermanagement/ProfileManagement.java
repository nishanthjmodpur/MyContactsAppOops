package com.contactsapp.usermanagement;

/**
 * UC3: User Profile Management
 * This class lets users update profile management. It makes use of User class setter methods to update information.
 */

public class ProfileManagement {
	public void updateName(User user, String newName) {
		user.setName(newName);
	}
	
	public void updateEmail(User user, String newEmail) {
		user.setEmail(newEmail);
	}
	
	public void updatePhoneNumber(User user, String newPhoneNumber) {
		user.setPhoneNumber(newPhoneNumber);
	}
	
	public void updatePassword(User user, String newPassword) {
		PasswordValidator passwordValidator = new PasswordValidator();
		String hashedPassword = passwordValidator.hashPassword(newPassword);
		user.setNewPassword(hashedPassword);
	}
	
	public void updateUserType(User user, int utype) {
		UserType userType = UserType.values()[utype - 1];
		user.setUserType(userType);
	}
}
