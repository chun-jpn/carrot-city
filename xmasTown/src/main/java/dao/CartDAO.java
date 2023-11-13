package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carts;
import model.Items;
import model.Users;

public class CartDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
//	カートアイテム追加メソッド
	public Carts insertCart(Items items, Users account ,int cartQuantity) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
//		初期値を入手
		String mail = account.getMail();
		int item_id = items.getItem_id();
		int price = items.getPrice();
		
//		データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			insert文の準備
			String sql = "INSERT INTO carts(mail, item_id, price, quantity) VALUES(?, ?, ?, ?)";
			// 登録するIDと名前をセットする
			// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
			PreparedStatement ps = conn.prepareStatement(sql);

			// 登録するIDと名前をセットする
			ps.setString(1, mail);
			ps.setInt(2, item_id);
			ps.setInt(3, price);
			ps.setInt(4, cartQuantity);
			Carts cart = new Carts(mail, item_id, price, cartQuantity);
//			SQL実行
			ps.executeUpdate();
			return cart;
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
	}
	
//	カートアイテム検索メソッド
	public List<Carts> findByData(String userMail) {
		List<Carts> cartList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			select文の準備
			String sql = "SELECT c.*, i.item_name, i.picture FROM carts c " +
					"INNER JOIN items i ON c.item_id = i.item_id " +
					"WHERE c.mail = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userMail);
//			結果表を取得
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
//			結果を取得する処理
				int cart_id = rs.getInt("cart_id");
				String mail = rs.getString("mail");
				int item_id = rs.getInt("item_id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String itemName = rs.getString("item_name");
				String picture = rs.getString("picture");
				
				
				Carts cartInPicture = new Carts(cart_id, mail, item_id, price, quantity, itemName, picture);
				cartList.add(cartInPicture);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return cartList;
	}
	
//	購入数変更メソッド
	public void changeCart(int quantity, int cart_id, int item_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			update文の準備
			String sql = "UPDATE carts SET quantity = ? WHERE cart_id = ? AND item_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, quantity);
			pStmt.setInt(2, cart_id);
			pStmt.setInt(3, item_id);
//			SQL実行
			pStmt.executeUpdate();
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
//	購入品削除メソッド
	public void deleteCart(int cart_id, int item_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
			String sql = "DELETE FROM carts WHERE cart_id=? and item_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, cart_id);
	        pStmt.setInt(2, item_id);

	        // DELETE文を実行
	        pStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
