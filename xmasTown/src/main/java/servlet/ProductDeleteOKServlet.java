package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ItemsDAO;
import model.Items;

/**
 * Servlet implementation class ProductDeleteOKServlet
 */
@WebServlet("/ProductDeleteOKServlet")
public class ProductDeleteOKServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    //セッションスコープからアイテムを取得
    Items item = (Items) session.getAttribute("items");

    int item_id = item.getItem_id();

    // DAOを呼び出して商品を削除する
    ItemsDAO dao = new ItemsDAO();
    dao.deleteItem(item_id);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productDeleteOK.jsp");
    dispatcher.forward(request, response);
  }

}
