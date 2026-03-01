package com.contactsapp.contactmanagement;

/**
 * UC4: Contact Creation
 * Defines a person contact. It extends from contact class
 */

public class PersonContact extends Contact {
	
	public PersonContact(String name) {
		super(name);
	}
	
	@Override
	public String getContactType() {
		return "PERSON";
	}
}
