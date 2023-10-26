package model;

import dao.UsersDAO;

public class LoginLogic {
	public boolean execute (Login login)  {
		UsersDAO dao = new UsersDAO();
		UserAccount userAccount = (UserAccount) dao.findAll();
		return userAccount != null;   //ありでture  なしでfalse
	}
}
