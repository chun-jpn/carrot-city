package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	  	String confirmLogout = request.getParameter("confirm");
    	if ("いいえ".equals(confirmLogout)) {
            // ユーザがログアウト確認をキャンセルした場合の処理フォワード
    		//WEBサイト上でボタンを押す動作は外部から接続する関係でWEB-INF繋がらないのでWelcomeServlet
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomeServlet");
        	dispatcher.forward(request, response);
        	
        	// ログアウトをキャンセルするメッセージを表示
        	System.out.println("ログアウトをキャンセルしました");
        	
        } else {
            // ログアウト確認メッセージを表示
        	System.out.println("ログアウトしますか？");

        	// ログアウト画面にフォワード
        	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/logout.jsp");
        	dispatcher.forward(request, response);
        }
  	}
}