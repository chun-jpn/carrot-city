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

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/contact.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String contactName = request.getParameter("name");
	    String contactMail = request.getParameter("mail");
	    String contactMessage = request.getParameter("message");
		  
		  //String error = null;
		  
		  //if (contactName.isEmpty() || contactMail.isEmpty() || contactMessage.isEmpty()) {
	          // エラーメッセージをセットしてフォームを再表示
			//  request.setAttribute("error", "名前、メールアドレス、メッセージ入力は必須です。");
		//	  request.getRequestDispatcher("WEB-INF/jsp/contact.jsp").forward(request, response);
		  //     System.out.println("名前、メール、メッセージ入力は必須です。");
		  //} else {
	            ContactDAO contactDAO = new ContactDAO();
	            
	         // 重複がない場合は新しいユーザを登録
                Contact contact = new Contact(contactName, contactMail, contactMessage);
                contactDAO.InsertContact(contact);
                request.getRequestDispatcher("WEB-INF/jsp/contactOK.jsp").forward(request, response);
                System.out.println("お問い合わせOK。");
	     // }
	 }
}

