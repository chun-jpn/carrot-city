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
			
			return cart;
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
	}
	
	
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
				String mail = rs.getString("mail");
				int item_id = rs.getInt("item_id");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String itemName = rs.getString("item_name");
				String picture = rs.getString("picture");
				
				
				Carts cartInPicture = new Carts(mail, item_id, price, quantity, itemName, picture);
				cartList.add(cartInPicture);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return cartList;
	}
}
