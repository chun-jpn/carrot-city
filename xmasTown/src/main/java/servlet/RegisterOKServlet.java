package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.Users;


@WebServlet("/RegisterOKServlet")
public class RegisterOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String userName = request.getParameter("name");
	    String address = request.getParameter("address");
	    String tel = request.getParameter("tel");
	    String mail = request.getParameter("mail");
	    String password = request.getParameter("password");
	    

			// modelクラスのインスタンス
			Users input_user = new Users();
			
			// modelクラスに入力したユーザIDをセットする
			input_user.setUserName(userName);
			input_user.setAddress(address);
			input_user.setTel(tel);
			input_user.setMail(mail);
			input_user.setPassword(password);
					
			// 登録処理実行
			RegisterDAO.getInstance().InsertUser(input_user);
			// 登録処理が問題なく完了した場合は検索画面のJSPに遷移する
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp");
	        rd.forward(request, response);
		// メッセージを表示
		System.out.println("新規登録されました！");
	}
}

