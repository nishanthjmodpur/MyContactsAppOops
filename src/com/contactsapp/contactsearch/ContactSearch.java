package com.contactsapp.contactsearch;

import java.util.ArrayList;

import com.contactsapp.contactmanagement.Contact;

public interface ContactSearch {
	ArrayList<Contact> searchContacts(ArrayList<Contact> contacts, String searchQuery);
}
