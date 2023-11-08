package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;


public class RegisterDAO {
	// データベース接続に使用する情報
	private final static String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town";
	private final static String DB_user = "root";
	private final static String DB_pass = "";
	
	
	private static final String CHECK_EMAIL_QUERY = "SELECT COUNT(*) FROM users WHERE mail = ?";
	
	// インスタンスオブジェクトを返却してコード簡略化
		public static RegisterDAO getInstance() {
			return new RegisterDAO();
		}

public boolean InsertUser(Users input_user) {
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
			return false;			
		}
public boolean isMailAlreadyRegistered(String mail) {
	//メールアドレスが登録済みかどうかチェックする
    try (Connection connection =DriverManager.getConnection(JDBC_url, DB_user, DB_pass);
        PreparedStatement ps = connection.prepareStatement(CHECK_EMAIL_QUERY)) {
    	ps.setString(1, mail);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // メールアドレスが既に登録済みの場合、trueを返す
            
        }
    	} catch (SQLException e) {
        e.printStackTrace();
    	}
    return false; // エラーの場合や該当するレコードが見つからない場合はfalseを返す
	}
}
