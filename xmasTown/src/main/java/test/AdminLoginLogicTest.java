package test;

import model.AdminLogin;
import model.AdminLoginLogic;

public class AdminLoginLogicTest {
	public static void main (String[] args)  {
		testExecuteOK();
		testExecuteNG();
	}
	public static void testExecuteOK()  {
		AdminLogin adminLogin = new AdminLogin("owner001", "1234");
		AdminLoginLogic bo = new AdminLoginLogic();
		boolean result = bo.execute(adminLogin);
		if  (result)  {
			System.out.println("testExecuteOK:成功しました");
		} else {
			System.out.println("testExecuteOK;失敗しました");
		}
	}
	
	public static void testExecuteNG()  {
		AdminLogin adminLogin = new AdminLogin("owner001", "12345");
		AdminLoginLogic bo = new AdminLoginLogic();
		boolean result = bo.execute(adminLogin);
		if  (!result)  {
			System.out.println("testExecuteOK:成功しました");
		} else  {
			System.out.println("testExecuteOK:失敗しました");
		}
	}
}
