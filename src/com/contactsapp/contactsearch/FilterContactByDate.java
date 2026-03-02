package com.contactsapp.contactsearch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.contactsapp.contactmanagement.Contact;

/**
 * UC10: This class implements ContactFilter interface to filter contacts based on time they are created at.
 */

public class FilterContactByDate implements ContactFilter {
	@Override
	public ArrayList<Contact> filterContacts(ArrayList<Contact> contacts) {
		Collections.sort(contacts, Comparator.comparing(Contact::getCreatedAt));
		return contacts;
	}
}
