package com.contactsapp.contactmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * UC7: Delete contact
 * This class defines methods to add and delete user contacts to a list.
 */


public class UserContacts {
	private ArrayList<Contact> contacts;
	
	public UserContacts() {
		contacts = new ArrayList<Contact>();
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public void deleteContact(Scanner scanner) {
		if (contacts.isEmpty()) {
			System.out.println("No contacts to delete");
			return;
		}
		
		System.out.println("Contacts list");
		for (int i=0; i < contacts.size(); i++) {
			System.out.println((i+1) + ". " + contacts.get(i));
		}
		
		System.out.println("Please select contact to delete:");
		int index = scanner.nextInt();
		scanner.nextLine();
		
		if (index < 1 || index > contacts.size()) {
			System.out.println("Invalid contact number");
			return;
		}
		
		Contact contactToDelete = contacts.get(index-1);
		System.out.println("Are you sure you want to delete this contact? (y/n)");
		System.out.println(contactToDelete.toString());
		String confirm = scanner.nextLine();
		
		if (confirm.toLowerCase().equals("y")) {
			contacts.remove(index-1);
			System.out.println("Contact deleted");
		} else {
			System.out.println("Contact not deleted");
		}
	}
	
}
