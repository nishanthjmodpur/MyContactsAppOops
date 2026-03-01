package com.contactsapp.main;

import java.util.HashMap;
import java.util.Scanner;

import com.contactsapp.usermanagement.BasicAuth;
import com.contactsapp.usermanagement.RegisterUser;
import com.contactsapp.usermanagement.Session;
import com.contactsapp.usermanagement.SessionManagement;
import com.contactsapp.usermanagement.User;
import com.contactsapp.usermanagement.UserType;

/**
 * MyContactsApp - Use case 1: User Registration
 * 
 * This class serves as the application entry point.
 * It demonstrates basic registration with validation.
 * 
 * @author Developer
 * @version 1.0
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		RegisterUser register = new RegisterUser();
		
		System.out.println("Enter your name:");
		String name = scanner.nextLine();
		
		System.out.println("Enter your email:");
		String email = scanner.nextLine();
		
		System.out.println("Enter your password:");
		String password = scanner.nextLine();
		
		System.out.println("Enter your phone number:");
		String phoneNumber = scanner.nextLine();
		
		System.out.println("Enter user type:");
		System.out.println("1.Free\n2.Premium");
		int userType = scanner.nextInt();
		scanner.nextLine();
		
		User user = register.registerUser(name, email, password, phoneNumber, UserType.values()[userType - 1]);
		System.out.println("User registered successfully!!");
		System.out.println("name: " + user.getName() + "\n" + "email: " + user.getEmail() + "\n" + "phone number: " + user.getPhoneNumber() + "\n" + "user type: " + user.getUserType());
		
		BasicAuth basicAuth = new BasicAuth();
		
		System.out.println("Enter your email for login:");
		String loginEmail = scanner.nextLine();
		
		System.out.println("Enter your password for login:");
		String loginPassword = scanner.nextLine();
		
		boolean successfulLogin = basicAuth.login(loginEmail, loginPassword, register.getUsers());
//		HashMap<String, Session> sessions = new HashMap<String, Session>();
		SessionManagement sessionManagement = new SessionManagement();
		
		if (successfulLogin) {
			System.out.println("Auth successful!!");
			String sessionId = sessionManagement.createSession(user);
			System.out.println("Session Created successfully!!");
			sessionManagement.logout(sessionId);
		}
		
		
		scanner.close();
	}

}
