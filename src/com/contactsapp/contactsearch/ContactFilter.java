package com.contactsapp.contactsearch;

import java.util.ArrayList;

import com.contactsapp.contactmanagement.Contact;

public interface ContactFilter {
	ArrayList<Contact> filterContacts(ArrayList<Contact> contacts);
}
