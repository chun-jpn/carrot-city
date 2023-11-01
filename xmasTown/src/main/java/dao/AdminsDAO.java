package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.AdminLogin;


public class AdminsDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
	public Admin findByLogin(AdminLogin AdminLogin) {
		Admin account = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
//		データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			select文の準備
			String sql = "select * from owners where owner_id=? and owner_pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, AdminLogin.getOwnerId());
			pStmt.setString(2, AdminLogin.getOwnerPass());
//			結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
//			ユーザーが存在したらデータ取得
//			そのユーザーが表すAccountインスタンスを生成
			String ownerId = rs.getString("owner_id");
			String ownerName = rs.getString("owner_name");
			String ownerPass = rs.getString("owner_pass");
			
			
			account = new Admin(ownerId, ownerName, ownerPass);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
		return account;
	}
}
