package model;

public class Login {
	private String userId;
	private String password;
	public Login (String userId, String password)  {
		this.userId = userId;
		this.password = password;
	}
	public String getUserId()  { return userId; }
	public String getPass()  { return password; }
}
