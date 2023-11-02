package test;

import dao.AdminsDAO;
import model.Admin;
import model.AdminLogin;


public class AdminsDAOTest {

	public static void main(String[] args)  {
		testFindByLoginOK();  //ユーザーが見つかる場合のテスト
		testFindByLoginNG();  //ユーザーが見つからない場合のテスト
	}
	
	public static void testFindByLoginOK()  {
		AdminLogin adminLogin = new AdminLogin("owner001", "1234");
		AdminsDAO dao = new AdminsDAO();
		Admin result = dao.findByLogin(adminLogin);
		
		if  (result != null &&
			result.getOwnerId().equals("owner001") &&
			result.getOwnerName().equals("ユーザー名")&&
			result.getOwnerPass().equals("1234" ) ) {
			
			System.out.println("testFindByLoginOK:成功しました");			
		} else {
			System.out.println("testFindByLoginOK:失敗しました");			
		}			
	}
	
	public static void testFindByLoginNG()  {
		AdminLogin adminLogin = new AdminLogin("owner001", "12345");
		AdminsDAO dao = new AdminsDAO();
		Admin result = dao.findByLogin(adminLogin);
		
		if  (result == null)  {
			System.out.println("testFindByLoginNG:成功しました");		
		} else {
			System.out.println("testFindByLoginNG:失敗しました");			
		}
	}
}
