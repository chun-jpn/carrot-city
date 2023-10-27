package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;


public class ItemsDAO{
	  private final String JDBC_URL = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "";
	  
	  public List<Items> getAll() {
		    List<Items> itemList = new ArrayList<Items>();
		    // JDBCドライバを読み込む
		    try {String drivername = "com.mysql.jdbc.Driver";
		        Class.forName(drivername);
		    } catch (ClassNotFoundException e) {
		        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		    }
		    // データベース接続
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		      // SELECT文の準備
		      String sql = "select * from";
		      PreparedStatement pStmt = conn.prepareStatement(sql);

		      // SELECTを実行
		      ResultSet rs = pStmt.executeQuery();

		      // SELECT文の結果をArrayListに格納
		      while (rs.next()) {
		        int id = rs.getInt("ID");
		        String userName = rs.getString("NAME");
		        String text = rs.getString("TEXT");
		        Mutter mutter = new Mutter(id, userName, text);
		        mutterList.add(mutter);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return mutterList;
		  }
		  public boolean create(Mutter mutter) {
			  // JDBCドライバを読み込む
			  try {String drivername = "com.mysql.jdbc.Driver";
				  Class.forName(drivername);
			  } catch(ClassNotFoundException e) {
			      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			  }
		    // データベース接続
		    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = "INSERT INTO MUTTERS(NAME, TEXT) VALUES(?, ?)";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setString(1, mutter.getUserName());
		      pStmt.setString(2, mutter.getText());

		      // INSERT文を実行（resultには追加された行数が代入される）
		      int result = pStmt.executeUpdate();
		      if (result != 1) {
		        return false;
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }
		    return true;
		  }

}
