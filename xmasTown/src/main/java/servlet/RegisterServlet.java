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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
		
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  String userName = request.getParameter("name");
	  String address = request.getParameter("address");
	  String tel = request.getParameter("tel");
	  String mail = request.getParameter("mail");
	  String password = request.getParameter("password");
	  
	  
	  //String error = null;
	  
	  if (userName.isEmpty() || address.isEmpty() || tel.isEmpty() || mail.isEmpty() || password.isEmpty()) {
          // エラーメッセージをセットしてフォームを再表示
		  request.setAttribute("error", "名前、住所、電話番号、メールアドレス、パスワードは必須です。");
		  request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
	       System.out.println("名前、住所、電話番号、メールアドレス、パスワードは必須です。");
	       
      	   } else {
            RegisterDAO registerDAO = new RegisterDAO();
            
            
            if (registerDAO.isMailAlreadyRegistered(mail)) {
            	// 重複エラーメッセージを設定してJSPにリダイレクト
                request.setAttribute("error", "既にメールアドレスが登録しております。別のメールアドレスを入力してください。");
                request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
                System.out.println("既にメールアドレスが登録しております。別のメールアドレスを入力してください。");
            } else {
            	// 重複がない場合は新しいユーザを登録
                Users users = new Users(userName, address, tel, mail, password);
                registerDAO.InsertUser(users);
                request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp").forward(request, response);
                System.out.println("新規登録OK。");
            
            }
        }
    }
}

// response.setContentType("text/html; charset=UTF-8");
//response.getWriter().append("").append(request.getContextPath());
// response.getWriter().write("登録がうまくいきませんでした");