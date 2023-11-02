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
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		/*
		Users user = new Users(); // JavaBeans Usersを生成し、登録済みの各情報を抜き出す
		UsersDAO ud = new UsersDAO();
		String name = user.getUserName(); // 名前を取得(jspに出力するため)
		String mail = user.getMail(); // メールを取得(ログイン状態を確認するため)
		String password = user.getPassword(); // パスワードを取得(ログイン状態を確認するため)
		System.out.println(name);
		Login login = new Login(mail, password); // Loginを生成し、メールとパスワードを登録
		LoginLogic bo = new LoginLogic(); //ビジネスオブジェクト。LoginLogicを生成
		boolean result = bo.execute(login); // 戻り値の「ture」「false」を受け取る
		*/
		
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("mail");
		String password = (String)session.getAttribute("password");
		
		Login login = new Login(mail, password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		
		if(result) { //ログイン成功時
			UsersDAO dao = new UsersDAO();
			Users account = dao.findByLogin(login); //戻り値;new Users(userName, address,tel, mail, password)
			String name = account.getUserName();
//			セッションに名前情報を投げる
			session.setAttribute("name", name);
			
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		}else { //ログイン失敗時 リダイレクトでログインサーブレットへ
			response.sendRedirect("LoginServlet");
		}
	}
}
