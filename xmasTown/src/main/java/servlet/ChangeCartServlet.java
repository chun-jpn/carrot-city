package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;


@WebServlet("/ChangeCartServlet")
public class ChangeCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cart_id = Integer.parseInt(request.getParameter("cart_id"));
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		
		
		CartDAO dao = new CartDAO();
		dao.changeCart(quantity, cart_id, item_id);
		
//		リダイレクトでカートサーブレットへ
		response.sendRedirect("CartServlet");
	}

}
