package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAO;
import dao.OrderDAO;
import model.Carts;
import model.Orders;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<Carts> cartsList =(ArrayList<Carts>)session.getAttribute("cartList");
		String mail = (String)session.getAttribute("mail");
		OrderDAO odao = new OrderDAO();
		ItemsDAO idao = new ItemsDAO();
		
		for(Carts orderItem : cartsList) {
//			ordersテーブルに購入品情報を追加
			Orders order = odao.insertOrder(orderItem);
//			insertOrderメソッドの戻り値:Orders order = new Orders(mail,item_id,quantity);
			int item_id = order.getItem_id();
			int quantity = order.getQuantity();
//			在庫数から購入数を引くメソッド(stock - quantity)
			idao.decStock(quantity, item_id);
		}
//		購入済みの商品をcartsテーブルから抹消
		odao.deleteOrder(mail);
//		セッションスコープから"cartList"を抹消
		session.removeAttribute("cartList");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/order.jsp");
		dispatcher.forward(request, response);
	}

	

}
