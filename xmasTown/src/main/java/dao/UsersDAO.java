package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.Users;

public class UsersDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
//	ユーザーアカウント取得
	public Users findByLogin(Login login) {
		Users account = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
//		データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			select文の準備
			String sql = "select * from users where mail=? and password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getMail());
			pStmt.setString(2, login.getPassword());
//			結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
//			ユーザーが存在したらデータ取得
//			そのユーザーが表すAccountインスタンスを生成
			String userName = rs.getString("user_name");
			String address = rs.getString("address");
			String tel = rs.getString("tel");
			String mail = rs.getString("mail");
			String password = rs.getString("password");
			
			account = new Users(userName, address,tel, mail, password);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
		return account;
	}
	
//	ユーザーアカウント削除
	public void deleteAccount(Login login) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
			String sql = "DELETE FROM users WHERE mail=? and password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, login.getMail());
	        pStmt.setString(2, login.getPassword());

	        // DELETE文を実行
	        int affectedRows = pStmt.executeUpdate();

	        if (affectedRows > 0) {
	            // 削除が成功した場合の処理
	            System.out.println("アカウントを削除しました");
	        } else {
	            // 削除が失敗した場合の処理
	            System.out.println("アカウントの削除に失敗しました");
	        }
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
//	ユーザーアカウント変更
	public void ChangeAccount(Users user, String old_mail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
			String sql = "update users set user_name=?, address=?, tel=?, mail=?, password=? where mail=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getAddress());
			pStmt.setString(3, user.getTel());
			pStmt.setString(4, user.getMail());
			pStmt.setString(5, user.getPassword());
			pStmt.setString(6, old_mail);

//			update文を実行
			pStmt.executeUpdate();
	        
//			トランザクションをコミット
			conn.commit();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
