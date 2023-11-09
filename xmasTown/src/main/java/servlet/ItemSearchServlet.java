package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import model.Items;

/**
 * Servlet implementation class ItemSearchServlet
 */
@WebServlet("/ItemSearchServlet")
public class ItemSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String category = request.getParameter("category");
		
		ItemsDAO dao = new ItemsDAO();
//		List<Items> itemsList = dao.findAll();
		List<Items> itemsList = dao.findByCategory(category);
		request.setAttribute("itemsList", itemsList);
		System.out.println(itemsList.get(0));

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/itemSearch.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

//		//リクエストパラメータの取得
//		request.setCharacterEncoding("UTF-8");
//		int itemId = Integer.parseInt(request.getParameter("item_id"));		
//		String category = request.getParameter("category");
//		String itemName = request.getParameter("item_name");
//		int price = Integer.parseInt(request.getParameter("price"));		
//		String comment = request.getParameter("comment");
//		int releaseFlag = Integer.parseInt(request.getParameter("release_flag"));		
//		String addDate = request.getParameter("add_date");
//		String rewriteDate = request.getParameter("rewrite_date");
//		String picture = request.getParameter("picture");

		//        Itemslogic bo = new Itemslogic();
	

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/itemSearch.jsp");
		dispatcher.forward(request, response);

	}

}
