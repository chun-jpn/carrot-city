package model;

import java.io.Serializable;

public class Contact implements Serializable {
	private String contactName;
	private String contactMail;
	private String contactMessage;
	
	
	public Contact(){}
	public Contact(String contactName, String contactMail, String contactMessage) {
		this.contactName = contactName;
		this.contactMail = contactMail;
		this.contactMessage = contactMessage;
		
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
        this.contactName = contactName;
	}
	public String getContactMail() {
		return contactMail;
	}
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}
	public String getContactMessage() {
		return contactMessage;
	}
	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;	
	}
}
