package model;

import dao.AdminsDAO;

public class AdminLoginLogic {
	public boolean execute (AdminLogin AdminLogin)  {
		AdminsDAO dao = new AdminsDAO();
		Admin account = dao.findByLogin(AdminLogin);
	    return account != null; //ありでture  なしでfalse
	}
}
