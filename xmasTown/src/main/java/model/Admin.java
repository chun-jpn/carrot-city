package model;

import java.io.Serializable;

public class Admin implements Serializable {
	private String ownerId;
	private String ownerName;
	private String ownerPass;
	
	
	public Admin(){}
	public Admin(String ownerId, String ownerName, String ownerPass) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerPass = ownerPass;
		
	}
	
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPass() {
		return ownerPass;
	}
	public void setOwnerPass(String ownerPass) {
		this.ownerPass = ownerPass;	
	}
}
