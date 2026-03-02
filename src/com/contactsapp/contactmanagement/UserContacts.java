package com.contactsapp.contactmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		
		if (contacts.isEmpty()) {
			System.out.println("No contacts remaining!");
		} else {
			System.out.println("Remaining contacts:");
			for (Contact contact : contacts) {
				System.out.println(contact.toString());
			}
		}
	}
	
	public void bulkDeleteContacts(Scanner scanner) {
		if (contacts.isEmpty()) {
			System.out.println("No contacts to delete");
			return;
		}
		
		System.out.println("Contacts list");
		for (int i=0; i < contacts.size(); i++) {
			System.out.println((i+1) + ". " + contacts.get(i));
		}
		
		System.out.println("Select contacts to delete (comma seperated values like 1,2,3:");
		String input = scanner.nextLine();
		String[] parts = input.split(",");
		Set<Integer> indicesToDelete = new HashSet<Integer>();
		for (String part : parts) {
			int num = Integer.parseInt(part.trim());
			indicesToDelete.add(num-1);
		}
		
		if (indicesToDelete.isEmpty()) {
			System.out.println("No contacts to delete");
			return;
		}
		
		System.out.println("Delete " + indicesToDelete.size() + " contacts (y/n)");
		String confirmChoice = scanner.nextLine();
		if (confirmChoice.toLowerCase().equals("y")) {
			ArrayList<Contact> remaining = new ArrayList<Contact>();
			for (int i=0; i < contacts.size(); i++) {
				if (!indicesToDelete.contains(i)) {
					remaining.add(contacts.get(i));
				}
			}
			contacts.clear();
			contacts.addAll(remaining);
			System.out.println("Contacts deleted");
		} else {
			System.out.println("Bulk delete cancelled!!");
		}
	}
	
}
