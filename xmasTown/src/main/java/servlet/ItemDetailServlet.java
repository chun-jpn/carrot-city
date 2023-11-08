package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String error = "";
		 
 		try{
 			//パラメータの取得
 			String id = request.getParameter("id");
 
 			//DTOオブジェクト宣言
 			ItemInfo account = new ItemInfo();
 
 			//DAOオブジェクト宣言
 			ItemsDao objDao = new ItemsDao();
 
 			//1件検索メソッドを呼び出し
 			account = objDao.selectById(id);
 
 			//検索結果を持ってlist3.jspにフォワード
 			request.setAttribute("account", account);
 
 		}catch (IllegalStateException e) {
 			error ="DB接続エラーの為、一覧表示はできませんでした。";
 
 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;
 
 		}finally{
 			request.setAttribute("error", error);
 			request.getRequestDispatcher("/view/ch13/list3.jsp").forward(request, response);
 		}
 	}
		
}
