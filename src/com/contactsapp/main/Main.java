package com.contactsapp.main;

import java.util.Scanner;

import com.contactsapp.usermanagement.RegisterUser;
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
		
		User user = RegisterUser.registerUser(name, email, password, phoneNumber, UserType.values()[userType - 1]);
		System.out.println("User registered successfully!!");
		System.out.println("name: " + user.getName() + "\n" + "email: " + user.getEmail() + "\n" + "phone number: " + user.getPhoneNumber() + "\n" + "user type: " + user.getUserType());
	}

}
