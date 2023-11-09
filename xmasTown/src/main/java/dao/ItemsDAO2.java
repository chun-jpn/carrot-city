package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class ItemsDAO2 {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	 //商品詳細
	public List<Items> selectById(String item_id) {//findAll() {
		List<Items> itemsList = new ArrayList<Items>();
		    // JDBCドライバを読み込む
		    try {String drivername = "com.mysql.jdbc.Driver";
		        Class.forName(drivername);
		    } catch (ClassNotFoundException e) {
		        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		    }
		    
		    // データベース接続
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		      // SELECT文の準備
		    
//		      String sql = "select * from items";
		      String sql =  "SELECT * FROM items WHERE item_id = ?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1,item_id);
		      // SELECTを実行
		      ResultSet rs = pStmt.executeQuery();

		      // SELECT文の結果をArrayListに格納
		      while (rs.next()) {
		        int itemId = rs.getInt("item_id");
		        String category = rs.getString("category");
		        String itemName = rs.getString("item_name");
		        int price = rs.getInt("price");
		        String comment = rs.getString("comment");
		        int quantity = rs.getInt("quantity");
		        int releaseFlag = rs.getInt("release_flag");
		        String addDate = rs.getString("add_date");
		        String rewriteDate = rs.getString("rewrite_date");
		        String picture = rs.getString("picture");
		        Items items = new Items(itemId,category,itemName,price,comment,quantity,releaseFlag,addDate,rewriteDate,picture);
		        itemsList.add(items);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return itemsList;
	  }

}
