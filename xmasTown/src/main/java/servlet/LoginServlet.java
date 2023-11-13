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
import model.LoginLogic;
import model.Users;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		// ログイン処理の実行
		Login login = new Login (mail,  password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		// ログイン処理の成否によって処理を分岐
		if  (result)  {  //ログイン成功時
			// セッションスコープにユーザーIDを保存
			UsersDAO dao = new UsersDAO();
			Users account = dao.findByLogin(login); //戻り値;new Users(userName, address,tel, mail, password)
			String name = account.getUserName();
			session.setAttribute("mail", mail);
			session.setAttribute("password", password);
			
			//名前を呼び出すコード
			session.setAttribute("name", name);
		
		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
				dispatcher.forward(request, response);
				System.out.println("ログインしました");
			} else  {  // ログイン失敗時
			// リダイレクト
				response.sendRedirect("LoginServlet");	
		}	
	}
}
