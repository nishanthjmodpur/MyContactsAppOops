package com.contactsapp.usermanagement;

import java.util.HashMap;

public class SessionManagement {
	private HashMap<String, Session> sessions  = new HashMap<String, Session>();

	
	public String createSession(User user) {
		Session session = new Session(user);
		sessions.put(session.getSessionId(), session);
		return session.getSessionId();
	}
	
	public Session getSession(String sessionId) {
		return sessions.get(sessionId);
	}
	
	public void logout(String sessionId) {
		Session session = sessions.get(sessionId);
		if (session != null) {
			session.invalidateSession();
			sessions.remove(sessionId);
		}
	}
}
