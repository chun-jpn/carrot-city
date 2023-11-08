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
import model.Users;


@WebServlet("/ChangeAccountOKServlet")
public class ChangeAccountOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String checkPass = request.getParameter("checkPass");	
		
//		セッションから新規登録用のUsersインスタンスを取得
		HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
//		String userName = user.getUserName();
//		String address = user.getAddress();
//		String tel = user.getTel();
		String mail = user.getMail();
        String password = user.getPassword();

//		セッションから既存のメールアドレスを呼び出す(データベースのwhereに指定するため)
        String old_mail = (String)session.getAttribute("mail");

//		リクエストパラメータとセッションスコープのパスワードを比較
        if(password.equals(checkPass)) {
//			同じならデータベースを更新する
        	UsersDAO dao = new UsersDAO();
        	dao.ChangeAccount(user, old_mail);
        	
//        	メールアドレスとパスワードを更新してセッションに保存
			session.setAttribute("mail", mail);
			session.setAttribute("password", password);
			
//			セッションスコープのuser削除
			session.removeAttribute("user");
			
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeAccountOK.jsp");
			dispatcher.forward(request, response);
        }else {
//        	違う場合、ChangeAccountNGservletへ
        	response.sendRedirect("ChangeAccountServlet");
        }
	}
}
