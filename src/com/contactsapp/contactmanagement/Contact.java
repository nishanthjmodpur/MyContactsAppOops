package com.contactsapp.contactmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.contactsapp.tagsorganization.Tag;

/**
 * UC4: Contact Creation
 * UC5: View Contacts
 * Defines an abstract contact class
 * defines getters and setters for the class
 * override toString() method to change display contacts format
 */

public abstract class Contact {
	private String contactId;
	private String name;
	private ArrayList<String> phoneNumbers;
	private ArrayList<String> emails;
	private LocalDateTime createdAt;
	private int contactFrequency;
	private Set<Tag> tags = new HashSet<>();
	
	public Contact(String name) {
		this.contactId = UUID.randomUUID().toString();
		this.name = name;
		this.phoneNumbers = new ArrayList<String>();
		this.emails = new ArrayList<String>();
		this.createdAt = LocalDateTime.now();
		this.contactFrequency = 0;
	}
	
	public Contact(Contact contact) {
		this.contactId = contact.contactId;
		this.name = contact.name;
		this.phoneNumbers = new ArrayList<String>(contact.phoneNumbers);
		this.emails = new ArrayList<String>(contact.emails);
	}
	
	public void addPhoneNumber(String phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}
	
	public void addEmail(String email) {
		emails.add(email);
	}
	
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public ArrayList<String> getEmails() {
		return emails;
	}
	
	@Override
	public String toString() {
		return "Name: " + name +"\n Phone numbers: " + phoneNumbers + "\nemails: " + emails;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void editPhoneNumbers(int index, String newPhoneNumber) {
		phoneNumbers.set(index, newPhoneNumber);
	}
	
	public void editEmails(int index, String newEmail) {
		emails.set(index, newEmail);
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public int getContactFrequency() {
		return contactFrequency;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public void removeTag(Tag tag) {
		tags.remove(tag);
	}
	
	
	public abstract String getContactType();
}
