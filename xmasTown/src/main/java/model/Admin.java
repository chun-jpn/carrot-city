package model;

public class Admin {
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
	public String getOwnerName() {
		return ownerName;
	}
	public String getOwnerPass() {
		return ownerPass;
	
	}
}
