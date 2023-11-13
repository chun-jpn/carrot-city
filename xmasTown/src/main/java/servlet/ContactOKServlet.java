package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import model.Contact;


@WebServlet("/ContactOKServlet")
public class ContactOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String C_name = request.getParameter("name");
	    String C_mail = request.getParameter("mail");
	    String C_message = request.getParameter("message");

	    

			// modelクラスのインスタンス
			Contact contact = new Contact();
			
			// modelクラスに入力したユーザIDをセットする
			contact.setContactName(C_name);
			contact.setContactMail(C_mail);
			contact.setContactMessage(C_message);

			// 登録処理実行
			ContactDAO.getInstance().InsertContact(contact);
			// 登録処理が問題なく完了した場合は検索画面のJSPに遷移する
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/contactOK.jsp");
	        rd.forward(request, response);
		// メッセージを表示
		System.out.println("お問い合わせがされました");
	}
}

