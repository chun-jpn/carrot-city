package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItem.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String itemName = request.getParameter("itemName");
		int price = Integer.parseInt(request.getParameter("price"));
		String comment = request.getParameter("comment");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int releaseFlag = Integer.parseInt(request.getParameter("releaseFlag"));
		String picture = request.getParameter("picture");
//		Itemsインスタンスの生成
		Items items = new Items(category, itemName, price, comment, quantity, releaseFlag, picture);
//		リクエストスコープに保存
		request.setAttribute("item", items);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItemConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
