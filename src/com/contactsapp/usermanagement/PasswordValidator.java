package com.contactsapp.usermanagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.contactsapp.invalidinputexception.InvalidInputException;

/**
 * UC1: This class is responsible for:
 * 		- validate if user entered password is greater than or equal to 8 characters.
 * 		- hash the password using the SHA-256 algorithm
 */

public class PasswordValidator {
	public String validatePassword(String password) throws InvalidInputException {
		if (password.length() < 8) {
			throw new InvalidInputException("Password must be at least 8 characters long");
		}
		return password;
	}
	
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder();
		for (byte h : hash) {
			hexString.append(String.format("%02x", h));
		}
		return hexString.toString();
	}
	
	public String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			final byte[] hash = md.digest(password.getBytes());
			return bytesToHex(hash);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
