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

@WebServlet("/ChangeAdminAccountServlet")
public class ChangeAdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String confirmLogout = request.getParameter("confirm");
		if ("キャンセル".equals(confirmLogout)) {
	        // 管理者が管理者情報変更をキャンセルした場合の処理フォワード
			//
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminMain.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	// ログアウトをキャンセルするメッセージを表示
	    	System.out.println("管理者情報変更をキャンセルしました");
		} else {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminConfirm.jsp");
		dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String checkPass = request.getParameter("checkPass");	
		
//		セッションから新規登録用のUsersインスタンスを取得
		HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

		String ownerId = admin.getOwnerId();
        String ownerPass = admin.getOwnerPass();

//		セッションから既存のメールアドレスを呼び出す(データベースのwhereに指定するため)
        String old_ownerId = (String)session.getAttribute("ownerId");

//		リクエストパラメータとセッションスコープのパスワードを比較
        if(ownerPass.equals(checkPass)) {
//			同じならデータベースを更新する
        	AdminsDAO dao = new AdminsDAO();
        	dao.UpdateAdmin(admin, old_ownerId);
        	
//        	管理者ユーザーIDとパスワードを更新してセッションに保存
			session.setAttribute("ownerId", ownerId);
			session.setAttribute("ownerPass", ownerPass);
			
//			セッションスコープのadmin削除
			session.removeAttribute("admin");
			
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeAdminAccount.jsp");
			dispatcher.forward(request, response);
        }else {
//        	違う場合、ChangeAccountNGservletへ
        	response.sendRedirect("AdminAccountServlet");
        }
	}
}

