package com.contactsapp.contactmanagement;

public class EditContact {
	public PersonContact editPersonContactName(PersonContact original, String newName) {
		PersonContact updated = new PersonContact(original);
		updated.setName(newName);
		return updated;
	}
	
	public OrganizationContact editOrganiationContactName(OrganizationContact original, String newName) {
		OrganizationContact updated = new OrganizationContact(original);
		updated.setName(newName);
		return updated;
	}
	
	public PersonContact editPersonContactPhoneNumber(PersonContact original, int index, String newPhoneNumber) {
		PersonContact updated = new PersonContact(original);
		updated.editPhoneNumbers(index, newPhoneNumber);
		return updated;	
	}
	
	public OrganizationContact editOrganizationContactPhoneNumber(OrganizationContact original, int index, String newPhoneNumber) {
		OrganizationContact updated = new OrganizationContact(original);
		updated.editPhoneNumbers(index, newPhoneNumber);
		return updated;	
	}
	
	public PersonContact editPersonContactEmails(PersonContact original, int index, String newEmail) {
		PersonContact updated = new PersonContact(original);
		updated.editEmails(index, newEmail);
		return updated;	
	}
	
	public OrganizationContact editOrganizationContactEmails(OrganizationContact original, int index, String newEmail) {
		OrganizationContact updated = new OrganizationContact(original);
		updated.editEmails(index, newEmail);
		return updated;	
	}
}
