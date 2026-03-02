package com.contactsapp.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.contactsapp.contactmanagement.Contact;
import com.contactsapp.contactmanagement.EditContact;
import com.contactsapp.contactmanagement.OrganizationContact;
import com.contactsapp.contactmanagement.PersonContact;
import com.contactsapp.contactmanagement.UserContacts;
import com.contactsapp.contactsearch.ContactSearch;
import com.contactsapp.contactsearch.EmailSearch;
import com.contactsapp.contactsearch.NameSearch;
import com.contactsapp.contactsearch.PhoneSearch;
import com.contactsapp.usermanagement.BasicAuth;
import com.contactsapp.usermanagement.ProfileManagement;
import com.contactsapp.usermanagement.RegisterUser;
import com.contactsapp.usermanagement.Session;
import com.contactsapp.usermanagement.SessionManagement;
import com.contactsapp.usermanagement.User;
import com.contactsapp.usermanagement.UserType;

/**
 * MyContactsApp - Use case 5: View Contacts * 
 * This class serves as the application entry point.
 * It demonstrates basic registration with validation, authentication and user profile management.
 * Lets users update profile information, password.
 * Let's users create contacts of 2 types (Person, Organization)
 * Lets users view existing contacts (prints contacts)
 * Lets users edit contacts
 * Lets users delete contacts
 * 
 * 
 * @author Developer
 * @version 7.0
 */

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		RegisterUser register = new RegisterUser();
		BasicAuth basicAuth = new BasicAuth();
		SessionManagement sessionManagement = new SessionManagement();
		ProfileManagement profileManagement = new ProfileManagement();
		UserContacts userContacts = new UserContacts();
				;
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
				if (choiceYN.equals("y".toLowerCase())) {
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
			
			System.out.println("Create a new contact");
			System.out.println("Enter type of contact:\n1.Person\n2.Organization");
			int contactType = scanner.nextInt();
			scanner.nextLine();
			if (contactType == 1) {
				PersonContact contact = new PersonContact(name);
				System.out.println("Enter email:");
				String contactEmail = scanner.nextLine();
				contact.addEmail(contactEmail);
				
				System.out.println("Enter phoneNumber:");
				String contactPhoneNumber = scanner.nextLine();
				contact.addPhoneNumber(contactPhoneNumber);
				
				System.out.println(contact.getContactType());
				System.out.println(contact.toString());
				
				EditContact editContact = new EditContact();
				contact = editContact.editPersonContactName(contact, "newName");
				System.out.println(contact.toString());
				
				userContacts.addContact(contact);
			} else if (contactType == 2) {
				OrganizationContact contact = new OrganizationContact(name);
				System.out.println("Enter email:");
				String contactEmail = scanner.nextLine();
				contact.addEmail(contactEmail);
				
				System.out.println("Enter phoneNumber:");
				String contactPhoneNumber = scanner.nextLine();
				contact.addPhoneNumber(contactPhoneNumber);
				
				System.out.println(contact.getContactType());
				System.out.println(contact.toString());
				
				EditContact editContact = new EditContact();
				editContact.editOrganiationContactName(contact, "newName");
				System.out.println(contact.toString());
				
				userContacts.addContact(contact);
			}
			
			System.out.println("Do you want to delete a contact? (y/n)");
			String deleteChoice = scanner.nextLine();
			if (deleteChoice.toLowerCase().equals("y")) {
				userContacts.deleteContact(scanner);
			}
			
			System.out.println("Do you want to bulk delete contacts? (y/n)");
			String choice = scanner.nextLine();
			if (choice.toLowerCase().equals("y")) {
				userContacts.bulkDeleteContacts(scanner);
			}
			
			System.out.println("Search contacts");
			System.out.println("Search bY:\n1.Name\n2.Email\n3.Phone");
			int searchChoice = scanner.nextInt();
			scanner.nextLine();
			
			ContactSearch search = null;
			if (searchChoice == 1) {
				search = new NameSearch();
			} else if (searchChoice == 2) {
				search = new EmailSearch();
			} else if (searchChoice == 3) {
				search = new PhoneSearch();
			}
			
			System.out.println("Please enter search query:");
			String query = scanner.nextLine();
			
			ArrayList<Contact> searchResults = search.searchContacts(userContacts.getAllContacts(), query);
			if (searchResults.isEmpty()) {
				System.out.println("No contacts found");
			} else {
				System.out.println("Search results:");
				for (Contact contact : searchResults) {
					System.out.println(contact.toString());
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
