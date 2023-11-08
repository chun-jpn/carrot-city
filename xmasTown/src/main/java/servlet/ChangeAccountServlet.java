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
import model.Users;

/**
 * Servlet implementation class ChangeAccountServlet
 */
@WebServlet("/ChangeAccountServlet")
public class ChangeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("mail");
		String password = (String)session.getAttribute("password");
		Login login = new Login(mail, password);
		UsersDAO dao = new UsersDAO();
//		ログインユーザーの情報を取得
		Users account = dao.findByLogin(login);
//		セッションに保存
		session.setAttribute("account", account);
		
//		フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/changeAccount.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
//		登録内容変更プログラム
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String address = request.getParameter("address");	
		String tel = request.getParameter("tel");	
		String mail = request.getParameter("mail");	
		String password = request.getParameter("password");	
		//Usersインスタンスの生成
		Users user = new Users(userName, address,tel, mail, password);
//		セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirm.jsp");
		dispatcher.forward(request, response);
	}
	
}
