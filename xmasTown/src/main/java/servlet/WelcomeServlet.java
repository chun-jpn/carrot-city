package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import model.Items;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String error = "";
		 
 		try{
 			//パラメータの取得
 //			int item_id = Integer.parseInt(request.getParameter("item_id"));
 
 			//DAOオブジェクト宣言
 			ItemsDAO itemsDAO = new ItemsDAO();
 
 			//リスト
 			List<Items> itemsList = itemsDAO.randById();
 			request.setAttribute("itemsList", itemsList);
// 			//検索結果を持ってjspにフォワード
// 			HttpSession session = request.getSession();
// 			session.setAttribute("items",items);
 
 		}catch (IllegalStateException e) {
 			error ="DB接続エラーの為、一覧表示はできませんでした。";
 
 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;
 
 		}finally{
 			request.setAttribute("error", error);
 			request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(request, response);
 		}
 	}
		
//		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp");
//		dispatcher.forward(request,response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
