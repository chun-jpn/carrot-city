package test;

import dao.UsersDAO;
import model.Login;
import model.Users;

public class UsersDAOTest {

	public static void main(String[] args)  {
		testFindByLoginOK();  //ユーザーが見つかる場合のテスト
		testFindByLoginNG();  //ユーザーが見つからない場合のテスト
	}
	
	public static void testFindByLoginOK()  {
		Login login = new Login("sawa@miyabilink.jp", "1234");
		UsersDAO dao = new UsersDAO();
		Users result = dao.findByLogin(login);
		
		if  (result != null &&
			result.getUserName().equals("sawa") &&
			result.getAddress().equals("岐阜県岐阜市")&&
			result.getTel() == 581234567 &&
			result.getMail().equals("sawa@miyabilink.jp") &&
			result.getPassword().equals("1234") )  {
			
			System.out.println("testFindByLoginOK:成功しました");			
		} else {
			System.out.println("testFindByLoginOK:失敗しました");			
		}			
	}
	
	public static void testFindByLoginNG()  {
		Login login = new Login("sawa@miyabilink.jp", "12345");
		UsersDAO dao = new UsersDAO();
		Users result = dao.findByLogin(login);
		
		if  (result == null)  {
			System.out.println("testFindByLoginNG:成功しました");		
		} else {
			System.out.println("testFindByLoginNG:失敗しました");			
		}
	}
}
