package model;

public class Users {
	private String userName;
	private String address;
	private String tel;
	private String mail ;
	private String password;
	
	
	public Users(){}
	public Users(String userName, String address, String tel, String mail, String password) {
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
	public String getTel() {
		return tel;
	}
	public String getMail() {
		return mail;
	}
	public String getPassword() {
		return password;
	}
}
