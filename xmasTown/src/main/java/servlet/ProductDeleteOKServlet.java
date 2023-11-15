package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ItemsDAO;

/**
 * Servlet implementation class ProductDeleteOKServlet
 */
@WebServlet("/ProductDeleteOKServlet")
public class ProductDeleteOKServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // /**
  // * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  // */
  // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
  // ServletException, IOException {
  // // TODO Auto-generated method stub
  // response.getWriter().append("Served at: ").append(request.getContextPath());
  // }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 商品削除機能
    // request.setCharacterEncoding("UTF-8");
    // String checkMail = request.getParameter("checkMail");
    // String checkPass = request.getParameter("checkPass");
    //
    // HttpSession session = request.getSession();
    // String mail = (String) session.getAttribute("mail");
    // String password = (String) session.getAttribute("password");

    // if (mail.equals(checkMail) && password.equals(checkPass)) {
    // Login login = new Login(mail, password);
    // UsersDAO dao = new UsersDAO();
    ItemsDAO dao = new ItemsDAO();
    // アカウント削除メソッドの呼び出し
    // dao.deleteAccount(login);

    // 商品削除メソッドの呼び出し
    dao.deleteItem(0);
    // セッションからデータをクリア
    // session.invalidate();
    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productDeleteOK.jsp");
    dispatcher.forward(request, response);
    // } else {
    // // リダイレクト
    // response.sendRedirect("DeleteAccountServlet");
    // }

  }

}
