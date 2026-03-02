package com.contactsapp.tagsorganization;

import java.util.Objects;
import java.util.UUID;

public class Tag {
	private String tagId;
	private String tagName;
	
	public Tag(String tagName) {
		this.tagId = UUID.randomUUID().toString();
		this.tagName = tagName; 
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public String getTagId() {
		return tagId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Tag tag = (Tag) obj;
		return Objects.equals(tagName, tag.tagName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tagName);
	}
}
