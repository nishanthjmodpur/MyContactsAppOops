package com.contactsapp.contactsearch;

import java.util.ArrayList;

import com.contactsapp.contactmanagement.Contact;

public class PhoneSearch implements ContactSearch {
	@Override
	public ArrayList<Contact> searchContacts(ArrayList<Contact> contacts, String searchQuery) {
		ArrayList<Contact> searchResult = new ArrayList<Contact>();
		if (searchQuery == null) {
			return searchResult;
		}
		
		String searchQueryLower = searchQuery.toLowerCase();
		for (Contact contact : contacts) {
			for (String phoneNumber : contact.getPhoneNumbers()) {
				if (phoneNumber.contains(searchQueryLower)) {
					searchResult.add(contact);
					break;
				}
			}
		}
		return searchResult;
	}
}
