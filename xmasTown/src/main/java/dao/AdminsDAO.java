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
	
public void UpdateAdmin(Admin admin, String old_ownerId) {
	try {
			Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}
			//  DB接続
		
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){		
			// 実行するSQL文をセット（空文字）
			String sql = "UPDATE owners SET owner_id  =?, owner_name = ?, owner_pass =? WHERE owner_id =?";								
			// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
			PreparedStatement ps = conn.prepareStatement(sql);
			// 登録するIDと名前とパスワードをセットする
			ps.setString(1,  admin.getOwnerId());
			ps.setString(2, admin.getOwnerName());
			ps.setString(3, admin.getOwnerPass());
			ps.setString(4, old_ownerId);
					
			// SQL実行
			ps.executeUpdate();
			//トランザクションをコミット
			conn.commit();
					
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
}
