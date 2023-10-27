package model;

public class Users {
	private String userName;
	private String address;
	private int tel;
	private String mail ;
	private String password;
	
	
	public Users(){}
	public Users(String userName, String address, int tel, String mail, String password) {
		this.userName = userName;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.password = password;
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
