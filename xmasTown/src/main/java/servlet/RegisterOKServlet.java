package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterOKServlet")
public class RegisterOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録処理が問題なく完了した場合は検索画面のJSPに遷移する
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp");
	    rd.forward(request, response);
		
		// メッセージを表示
		System.out.println("新規登録されました！");	    
	    }
}

