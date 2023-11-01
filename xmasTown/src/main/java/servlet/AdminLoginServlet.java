package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminLogin;
import model.AdminLoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminLogin.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String ownerId = request.getParameter("ownerId");
		String ownerPass = request.getParameter("ownerPass");
		
		// ログイン処理の実行
		AdminLogin adminLogin = new AdminLogin (ownerId, ownerPass);
		AdminLoginLogic bo = new AdminLoginLogic();
		boolean result = bo.execute(adminLogin);
		
		// ログイン処理の成否によって処理を分岐
		if  (result)  {  //ログイン成功時
			// セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("ownerId", ownerId);
			session.setAttribute("ownerPass", ownerPass);
		
		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminMain.jsp");
				dispatcher.forward(request, response);
			} else  {  // ログイン失敗時
			// リダイレクト
				response.sendRedirect("AdminLoginServlet");	
		}	
	}
}
