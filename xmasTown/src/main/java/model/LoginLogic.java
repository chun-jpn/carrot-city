package model;

import dao.UsersDAO;

public class LoginLogic {
	public boolean execute (Login login)  {
		UsersDAO dao = new UsersDAO();
		Users account = dao.findByLogin(login);
	    return account != null; //ありでture  なしでfalse
	}
}
