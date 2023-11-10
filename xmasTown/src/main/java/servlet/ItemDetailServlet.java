package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import model.Items;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemDetailServlet")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		ItemDto itemDto = new ItemDto();
//		ItemDto.setItem_id	
		
		String error = "";
		 
 		try{
 			//パラメータの取得
 			String item_id = request.getParameter("item_id");
 
 			//DTOオブジェクト宣言
// 			Items items = new Items(item_id);
 
 			//DAOオブジェクト宣言
 			ItemsDAO itemsDAO = new ItemsDAO();
 
 			//1件検索メソッドを呼び出し
 			Items items = itemsDAO.selectById(item_id);
 
 			//検索結果を持ってjspにフォワード
 			request.setAttribute("items",items);
 
 		}catch (IllegalStateException e) {
 			error ="DB接続エラーの為、一覧表示はできませんでした。";
 
 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;
 
 		}finally{
 			request.setAttribute("error", error);
 			request.getRequestDispatcher("WEB-INF/jsp/itemDetail.jsp").forward(request, response);
 		}
 	}
		
}
