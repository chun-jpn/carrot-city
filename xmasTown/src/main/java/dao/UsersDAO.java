package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.UserAccount;

public class UsersDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
	public UserAccount findByLogin(Login login) {
		UserAccount account = null;
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
			int tel = rs.getInt("tel");
			String mail = rs.getString("mail");
			String password = rs.getString("password");
			
			account = new UserAccount(userName, address,tel, mail, password);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
		return account;
	}
}
