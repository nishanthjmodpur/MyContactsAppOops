package com.contactsapp.contactsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.contactsapp.contactmanagement.Contact;

public class FilterContactByContactFrequency implements ContactFilter {
	@Override
	public ArrayList<Contact> filterContacts(ArrayList<Contact> contacts) {
		Collections.sort(contacts, Comparator.comparing(Contact::getContactFrequency));
		return contacts;
	}
}
