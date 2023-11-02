package model;

public class AdminLogin {
	private String ownerId;
	private String ownerPass;
	public AdminLogin (String ownerId, String ownerPass)  {
		this.ownerId = ownerId;
		this.ownerPass = ownerPass;
	}
	public String getOwnerId()  { return ownerId; }
	public String getOwnerPass()  { return ownerPass; }
}
