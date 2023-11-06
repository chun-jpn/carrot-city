package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO2;
import model.Items;

/**
 * Servlet implementation class ItemSearchServlet
 */
@WebServlet("/ItemSearchServlet2")
public class ItemSearchServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		 
 		try{
 			//パラメータの取得
 			String category = request.getParameter("category");
 
 			//配列宣言
 			List<Items> itemsList = new ArrayList<Items>();
 
 			//オブジェクト宣言
 			ItemsDAO2 objDao2 = new ItemsDAO2();
 
 			//全検索メソッドを呼び出し
 			itemsList = objDao2.search(category);
 			System.out.println(itemsList);
 
 			//検索結果を持って.jspにフォワード
 			request.setAttribute("itemsList",itemsList );
 
 		}catch (IllegalStateException e) {
 			error ="DB接続エラーの為、一覧表示はできませんでした。";
 
 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;
 
 		}finally{
 			request.setAttribute("error", error);
 			request.getRequestDispatcher("WEB-INF/jsp/itemSearch.jsp").forward(request, response);
 		}
 	}
 }