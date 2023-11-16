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

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 商品IDを取得する
    String item_idStr = request.getParameter("item_id");
    // 商品IDがnullの場合は0を返す
    int item_id = item_idStr == null ? 0 : Integer.parseInt(item_idStr);

    // DAOを呼び出して商品を削除する
    ItemsDAO dao = new ItemsDAO();
    dao.deleteItem(item_id);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productDeleteOK.jsp");
    dispatcher.forward(request, response);
  }

}
