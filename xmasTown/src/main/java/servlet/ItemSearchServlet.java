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

		List<Items> itemsList = dao.findByCategory(category);
		request.setAttribute("itemsList", itemsList);
	

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/category.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {



		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/itemSearch.jsp");
		dispatcher.forward(request, response);

	}

}
