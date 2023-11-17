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


@WebServlet("/ProductChangeOKServlet")
public class ProductChangeOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//    	セッションスコープからItemsの情報を取得
    	HttpSession session = request.getSession();
        Items items = (Items) session.getAttribute("items");
//		ItemsDAOインスタンスを生成
        ItemsDAO dao = new ItemsDAO();
//      新しい情報でitemsテーブルを更新
		dao.productChange(items);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeOK.jsp");
		dispatcher.forward(request, response);
		
	}

}
