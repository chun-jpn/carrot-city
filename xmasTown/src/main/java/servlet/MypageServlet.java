package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Users user = new Users(); // JavaBeans Usersを生成し、登録済みの各情報を抜き出す
		String name = user.getUserName(); // 名前を取得(jspに出力するため)
		String mail = user.getMail(); // メールを取得(ログイン状態を確認するため)
		String password = user.getPassword(); // パスワードを取得(ログイン状態を確認するため)
		System.out.println(name);
		Login login = new Login(mail, password); // Loginを生成し、メールとパスワードを登録
		LoginLogic bo = new LoginLogic(); //ビジネスオブジェクト。LoginLogicを生成
		boolean result = bo.execute(login); // 戻り値の「ture」「false」を受け取る
		
		if(result) { //ログイン成功時
			HttpSession session = request.getSession(); // セッションスコープに名前の情報を登録
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
