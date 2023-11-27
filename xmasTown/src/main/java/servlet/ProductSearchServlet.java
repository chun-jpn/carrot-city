package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import model.Items;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
 //   request.setCharacterEncoding("UTF-8");

    String error = "";

    try {
      // パラメータの取得
      String item_name = request.getParameter("item_name");
      String page = request.getParameter("page");
      // 配列宣言
      List<Items> itemsList = new ArrayList<Items>();

      // オブジェクト宣言
      ItemsDAO objDao = new ItemsDAO();

      // 全検索メソッドを呼び出し
      itemsList = objDao.productSearch(item_name);

      // 検索結果を持ってproductSearch.jspにフォワード
      request.setAttribute("itemsList", itemsList);
      request.setAttribute("item_name", item_name);
	  request.setAttribute("page",page );
	  
    } catch (IllegalStateException e) {
      error = "DB接続エラーの為、一覧表示はできませんでした。";

    } catch (Exception e) {
      error = "予期せぬエラーが発生しました。<br>" + e;

    } finally {
      request.setAttribute("error", error);
      request.getRequestDispatcher("WEB-INF/jsp/productSearch.jsp").forward(request, response);
    }
  }

    
    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response)
    		throws ServletException, IOException {

    			//リクエストパラメータの取得
    			request.setCharacterEncoding("UTF-8");
    			
    
    }
}
