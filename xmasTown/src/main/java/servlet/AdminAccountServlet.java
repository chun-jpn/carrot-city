package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminsDAO;
import model.Admin;
import model.AdminLogin;

@WebServlet("/AdminAccountServlet")
public class AdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ownerId = (String)session.getAttribute("ownerId");
		String ownerPass = (String)session.getAttribute("ownerPass");
		AdminLogin adminLogin = new AdminLogin(ownerId, ownerPass);
		AdminsDAO dao = new AdminsDAO();
		//ログインユーザーの情報を取得
		Admin account = dao.findByLogin(adminLogin);
		//セッションに保存
		session.setAttribute("account", account);
		
		String confirmLogout = request.getParameter("confirm");
		if ("キャンセル".equals(confirmLogout)) {
	        // 管理者が管理者情報変更をキャンセルした場合の処理フォワード
			//
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminMain.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	// ログアウトをキャンセルするメッセージを表示
	    	System.out.println("管理者情報変更をキャンセルしました");
		} else {
		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/adminAccount.jsp");
		dispatcher.forward(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String ownerId = request.getParameter("ownerId");
		String ownerName = request.getParameter("ownerName");
        String ownerPass = request.getParameter("ownerPass");
        
      //Adminインスタンスの生成
        Admin admin = new Admin(ownerId, ownerName, ownerPass);
     	HttpSession session = request.getSession();
     	session.setAttribute("admin", admin);
     			    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminConfirm.jsp");
		dispatcher.forward(request, response);
    }
}
