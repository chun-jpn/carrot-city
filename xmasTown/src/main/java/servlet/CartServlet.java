package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.UsersDAO;
import model.Carts;
import model.Items;
import model.Login;
import model.LoginLogic;
import model.Users;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("mail");
		String password = (String)session.getAttribute("password");
//		ログイン確認
		Login login = new Login(mail, password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		
		if(result) { //ログイン成功時
			UsersDAO udao = new UsersDAO();
//			データベースからユーザー情報を取得
			Users account = udao.findByLogin(login); //戻り値;new Users(userName, address,tel, mail, password)
//			セッションにアカウント情報を投げる
			session.setAttribute("account", account);
			CartDAO cdao = new CartDAO();
			List<Carts> cartsList = cdao.findByData(mail);
			
				// セッションにカート情報をセット
			session.setAttribute("cartList", cartsList);
			
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request, response);
		}else { //ログイン失敗時 リダイレクトでログインサーブレットへ
			response.sendRedirect("LoginServlet");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int quantity = 1; //動作テスト用。正しくは下のコメントアウトプログラム
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("mail");
		String password = (String)session.getAttribute("password");
		
		
//		ログイン確認
		Login login = new Login(mail, password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		Items items = (Items)session.getAttribute("Items");
		
		if(result) { //ログイン成功時
			UsersDAO udao = new UsersDAO();
//			データベースからユーザー情報を取得
			Users account = udao.findByLogin(login); //戻り値;new Users(userName, address,tel, mail, password)
//			セッションにアカウント情報を投げる
			session.setAttribute("account", account);
//			セッションに購入品の情報を投げる
			session.setAttribute("item", items);
			CartDAO cdao = new CartDAO();
			Carts cart = cdao.insertCart(items, account, quantity);
			
			if (cart != null) { // カートに商品が追加できた場合
				// カート内の情報を取得
				List<Carts> cartsList = cdao.findByData(mail);

				// セッションにカート情報をセット
				session.setAttribute("cartList", cartsList);
			}else { // カートへの追加に失敗した場合、商品詳細ページへリダイレクト
				response.sendRedirect("ItemDetailServlet");
			}
			
			
//			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request, response);
		}else { //ログイン失敗時 リダイレクトでログインサーブレットへ
			response.sendRedirect("LoginServlet");
		}
		
	}

}
