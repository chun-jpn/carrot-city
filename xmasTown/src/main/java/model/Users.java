package model;

import java.io.Serializable;

public class Users implements Serializable {
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
	public void setUserName(String userName) {
        this.userName = userName;
    }
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
        this.address = address;
    }
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
