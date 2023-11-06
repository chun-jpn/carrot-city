package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Users;


public class RegisterDAO {
	 // データベース接続に使用する情報
	private final String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town";
	private final String DB_user = "root";
	private final String DB_pass = "";
	
	// インスタンスオブジェクトを返却してコード簡略化
		public static RegisterDAO getInstance() {
			return new RegisterDAO();
		}

public void InsertUser(Users input_user) {
	// 初期値をセット
			Connection db_con = null;
			String name = input_user.getUserName();
			String address = input_user.getAddress();
			String tel = input_user.getTel();
			String mail = input_user.getMail();
			String password = input_user.getPassword();

			try {
				// jdbcドライバの読み込み（OracleDB）
				Class.forName("com.mysql.jdbc.Driver");
			
				//  DB接続
				db_con = DriverManager.getConnection(JDBC_url, DB_user, DB_pass);
			
				// 実行するSQL文をセット（空文字）
				String sql = "INSERT INTO users(user_name, address, tel, mail, password) VALUES(?, ?, ?, ?, ?)";
							
				// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
				PreparedStatement ps = db_con.prepareStatement(sql);

				// 登録するIDと名前をセットする
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, tel);
				ps.setString(4, mail);
				ps.setString(5, password);
				
				// SQL実行
				ps.executeUpdate();
				
				
			} catch(SQLException sql_e) {
				// エラーハンドリング
				System.out.println("sql実行失敗");
				sql_e.printStackTrace();
				
			} catch(ClassNotFoundException e) {
				// エラーハンドリング
				System.out.println("JDBCドライバ関連エラー");
				e.printStackTrace();
				
			} finally {
				// DB接続を解除
				if (db_con != null) {
						try {
							db_con.close();
						} catch (SQLException e) {
							System.out.println("sqlクローズ失敗");
							e.printStackTrace();
						}
				}
			}
		}
}
