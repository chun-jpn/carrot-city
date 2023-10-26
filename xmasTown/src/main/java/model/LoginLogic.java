package model;

import dao.UsersDAO;

public class LoginLogic {
	public boolean execute (Login login)  {
		UsersDAO dao = new UsersDAO();
		UserAccount account = dao.findByLogin(login);
	    return account != null; //ありでture  なしでfalse
	}
}
