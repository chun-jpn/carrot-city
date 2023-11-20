package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItemFakeServlet
 */
@WebServlet("/AddItemFakeServlet")
public class AddItemFakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            // 2.5秒の遅延をシミュレート
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItemConfirm.jsp");
        dispatcher.forward(request, response);
	}

}
