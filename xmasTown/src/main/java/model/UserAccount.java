package model;

public class UserAccount {
	private int userId;
	private String userName;
	private String address;
	private int tel;
	private String mail ;
	private String password;
	
	
	public UserAccount(){}
	public UserAccount(int id, String name, String address, int tel, String mail, String password) {
		this.userId = id;
		this.userName = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getAddress() {
		return address;
	}
	public int getTel() {
		return tel;
	}
	public String getMail() {
		return mail;
	}
	public String getPassword() {
		return password;
	}
}
