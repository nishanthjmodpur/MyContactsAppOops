package com.contactsapp.main;

import java.util.HashMap;
import java.util.Scanner;

import com.contactsapp.usermanagement.BasicAuth;
import com.contactsapp.usermanagement.ProfileManagement;
import com.contactsapp.usermanagement.RegisterUser;
import com.contactsapp.usermanagement.Session;
import com.contactsapp.usermanagement.SessionManagement;
import com.contactsapp.usermanagement.User;
import com.contactsapp.usermanagement.UserType;

/**
 * MyContactsApp - Use case 3: User Profile Management
 * 
 * This class serves as the application entry point.
 * It demonstrates basic registration with validation, authentication and user profile management.
 * Lets users update profile information, password.
 * 
 * 
 * @author Developer
 * @version 3.0
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		RegisterUser register = new RegisterUser();
		BasicAuth basicAuth = new BasicAuth();
		SessionManagement sessionManagement = new SessionManagement();
		ProfileManagement profileManagement = new ProfileManagement();

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
		
		//UC2
		System.out.println("Enter your email for login:");
		String loginEmail = scanner.nextLine();
		
		System.out.println("Enter your password for login:");
		String loginPassword = scanner.nextLine();
		
		boolean successfulLogin = basicAuth.login(loginEmail, loginPassword, register.getUsers());
		
		if (successfulLogin) {
			System.out.println("Auth successful!!");
			String sessionId = sessionManagement.createSession(user);
			System.out.println("Session Created successfully!!");
			while (true) {
				System.out.println("Do you want to change profile information (y/n)");
				String choiceYN = scanner.next();
				if (choiceYN.equals("y")) {
					System.out.println("Enter your choice:\n1.Name\n2.Email\3.Password\n4.Phone number\n5.UserType(1.Free, 2.Premium)");
					int choice = scanner.nextInt();
					scanner.nextLine();
					switch (choice) {
						case 1: {
							System.out.println("Enter new name:");
							String newName = scanner.nextLine();
							profileManagement.updateName(user, newName);
							break;
						}
						case 2: {
							System.out.println("Enter new email:");
							String newEmail = scanner.nextLine();
							profileManagement.updateEmail(user, newEmail);
							break;
						}
						case 3: {
							System.out.println("Enter new password:");
							String newPassword = scanner.nextLine();
							profileManagement.updatePassword(user, newPassword);
							break;
						}
						case 4: {
							System.out.println("Enter new phone number:");
							String newPhoneNumber = scanner.nextLine();
							profileManagement.updatePhoneNumber(user, newPhoneNumber);
							break;
						}
						case 5: {
							System.out.println("Enter new user type: (1.Free, 2.Premium");
							int newUtype = scanner.nextInt();
							scanner.nextLine();
							profileManagement.updateUserType(user, newUtype);
							break;
						}
						default: {
							System.out.println("Please enter a valid choice!!");
						}
					}
				} else {
					break;
				}
			}
			
			sessionManagement.logout(sessionId);
		} else {
			System.out.println("Wrong username or password!!");
		}

		System.out.println("Exit!!!!!!!");
		
		
		
		scanner.close();
	}

}
