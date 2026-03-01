package com.contactsapp.usermanagement;

import java.util.UUID;

/**
 * UC2 - User Authentication and Session management
 * This class defines a user Session
 * generates a new session with a random UUID as sessionId and sets status to true indicating
 * session is active.
 */

public class Session {
	private String sessionId;
	private User user;
	private boolean active;
	
	public Session(User user) {
		this.sessionId = UUID.randomUUID().toString();
		this.user = user;
		this.active = true;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public User getUser() {
		return user;
	}
	
	public boolean getStatus() {
		return active;
	}
	
	public void invalidateSession() {
		this.active = false;
	}
}
