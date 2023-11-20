package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class RankingDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
	public List<Items> getRanking() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		List<Items> rankingList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)) {
			String sql = "SELECT items.item_id, items.item_name, items.price, items.release_flag, items.picture, SUM(orders.quantity) AS total_quantity "
						+ "FROM orders "
						+ "JOIN items ON orders.item_id = items.item_id "
						+ "WHERE items.release_flag = 0 "
						+ "GROUP BY items.item_id "
						+ "ORDER BY total_quantity DESC "
						+ "LIMIT 5";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						int itemId = rs.getInt("item_id");
						String itemName = rs.getString("item_name");
						int price = rs.getInt("price");
						String picture = rs.getString("picture");
						int totalQuantity = rs.getInt("total_quantity");

						Items item = new Items(itemId, itemName, price, picture, totalQuantity);

						rankingList.add(item);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rankingList;
    }
	
}
