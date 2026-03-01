package com.contactsapp.contactmanagement;

/**
 * UC4: Contact Creation
 * Defines an organization contact. it extends contact class
 */
public class OrganizationContact extends Contact {
	
	public OrganizationContact(String companyName) {
		super(companyName);
	}

	@Override
	public String getContactType() {
		return "ORGANIZATION";
	}
}
