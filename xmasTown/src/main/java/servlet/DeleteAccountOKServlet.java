package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Login;

/**
 * Servlet implementation class DeleteAccountOKServlet
 */
@WebServlet("/DeleteAccountOKServlet")
public class DeleteAccountOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		アカウント削除機能
		request.setCharacterEncoding("UTF-8");
		String checkMail = request.getParameter("checkMail");
		String checkPass = request.getParameter("checkPass");
		
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("mail");
		String password = (String)session.getAttribute("password");
		
		if(mail.equals(checkMail) && password.equals(checkPass)) {
			Login login = new Login(mail, password);
			UsersDAO dao = new UsersDAO();
//			アカウント削除メソッドの呼び出し
			dao.deleteAccount(login);
			
//			セッションからデータをクリア
			session.invalidate();
//			フォワード
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/deleteAccountOK.jsp");
			dispatcher.forward(request,response);
		}else {
			// リダイレクト
			response.sendRedirect("DeleteAccountServlet");
		}
		
	}

}
