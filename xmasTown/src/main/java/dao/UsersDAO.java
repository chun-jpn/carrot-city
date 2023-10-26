package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserAccount;

public class UsersDAO {
	private final String JDBC_url = "jdbc:mysql://localhost:3306/dokotsubu?charaxterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
//	全ての情報をカラムごとにリストに格納
	public List<UserAccount> findAll(){
		List<UserAccount>userAccountList = new ArrayList<>();
//		JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
//		データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_url, DB_user, DB_pass)){
//			select文の準備(IDを大きい順に並べる
			String sql = "select * from MUTTERS order by ID desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
//			結果表を取得
			ResultSet rs = pStmt.executeQuery();
//			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String address = rs.getString("address");
				int tel= rs.getInt("tel");
				String mail= rs.getString("mail");
				String password= rs.getString("password");
				UserAccount userAccount = new UserAccount(userId, userName, address, tel, mail, password);
				userAccountList.add(userAccount);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null ;
		}
		return userAccountList;
	}
}
