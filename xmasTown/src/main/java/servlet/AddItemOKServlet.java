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

/**
 * Servlet implementation class AddItemOKServlet
 */
@WebServlet("/AddItemOKServlet")
public class AddItemOKServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	セッションスコープからItemsの情報を取得
    	HttpSession session = request.getSession();
        Items item = (Items) session.getAttribute("item");
//		ItemsDAOインスタンスを生成
        ItemsDAO dao = new ItemsDAO();
        
        // データベースへの挿入処理を行う
        try {
            dao.addItem(item);
            // 成功時の処理
            String successMessage = "アイテムが正常に登録されました。";
            request.setAttribute("successMessage", successMessage);
        } catch (Exception e) {
            // エラーハンドリング
            e.printStackTrace();
            String errorMessage = "アイテムの登録中にエラーが発生しました。";
            request.setAttribute("errorMessage", errorMessage);
        }

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItemOK.jsp");
        dispatcher.forward(request, response);
    }
}
