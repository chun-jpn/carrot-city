package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main (String[] args)  {
		testExecuteOK();
		testExecuteNG();
	}
	public static void testExecuteOK()  {
		Login login = new Login ("sawa@miyabilink.jp", "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if  (result)  {
			System.out.println("testExecuteOK:成功しました");
		} else {
			System.out.println("testExecuteOK;失敗しました");
		}
	}
	
	public static void testExecuteNG()  {
		Login login = new Login ("sawa@miyabilink.jp", "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if  (!result)  {
			System.out.println("testExecuteOK:成功しました");
		} else  {
			System.out.println("testExecuteOK:失敗しました");
		}
	}
}
