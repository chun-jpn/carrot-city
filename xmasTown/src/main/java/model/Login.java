package model;

public class Login {
	private String mail;
	private String password;
	public Login (String mail, String password)  {
		this.mail = mail;
		this.password = password;
	}
	public String getMail()  { return mail; }
	public String getPassword()  { return password; }
}
