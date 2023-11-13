package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Carts;

public class OrderDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

//購入アイテム追加	
	public void insertOrder(Carts carts) {
		// JDBCドライバを読み込む
		try {
			String drivername = "com.mysql.jdbc.Driver";
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//		初期値を入手
		String mail = carts.getMail();
		int item_id = carts.getItem_id();
		int quantity = carts.getQuantity();
		

		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//			insert文の準備

			//SQL文
			String sql = "INSERT INTO orders(mail, item_id, quantity, order_date) VALUES(?, ?, ?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// 登録する内容をセットする
			ps.setString(1, mail);
			ps.setInt(2, item_id);
			ps.setInt(3, quantity);
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(4, currentTimestamp);
//			Orders orders = new Orders( mail,item_id,quantity);
			//SQL実行
			ps.executeUpdate();

		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}		
	}
	
	//カート内容削除
			public void deleteOrder(String mail) {
				// JDBCドライバを読み込む
				try {
					String drivername = "com.mysql.jdbc.Driver";
					Class.forName(drivername);
				} catch (ClassNotFoundException e) {
					throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}

				
				// データベース接続
				try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
					//			insert文の準備
						String sql = "DELETE FROM carts WHERE mail=?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
				        pStmt.setString(1, mail);
//				        pStmt.setInt(2, item_id);

				        // DELETE文を実行
				        pStmt.executeUpdate();
				
			
				
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			}
}
	
//	public List<Orders> findByData(String userMail) {
//		List<Orders> OrdersList = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		}catch(ClassNotFoundException e) {
//			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
//		}
//		
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
////			select文の準備
//			String sql = "SELECT c.*, i.item_name,  FROM carts c " +
//					"INNER JOIN items i ON c.item_id = i.item_id " +
//					"WHERE c.mail = ?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, userMail);
////			結果表を取得
//			ResultSet rs = pStmt.executeQuery();
//			while (rs.next()) {
////			結果を取得する処理
//				String mail = rs.getString("mail");
//				int item_id = rs.getInt("item_id");
//				int price = rs.getInt("price");
//				int quantity = rs.getInt("quantity");
//				String itemName = rs.getString("item_name");
//				String picture = rs.getString("picture");
//				
//				
//				Orders orders = new Orders(mail, item_id, price, quantity, itemName, picture);
//				ordersList.add(Orders);
//	        }
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//			return null;
//		}
//		return cartList;
//	}
	
