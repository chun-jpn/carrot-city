package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contact;


public class ContactDAO {
	// データベース接続に使用する情報
	private final static String JDBC_url = "jdbc:mysql://localhost:3306/xmas_town";
	private final static String DB_user = "root";
	private final static String DB_pass = "";
	
	
	// インスタンスオブジェクトを返却してコード簡略化
		public static ContactDAO getInstance() {
			return new ContactDAO();
		}

public boolean InsertContact(Contact contact) {
	// 初期値をセット
			Connection db_con = null;
			String C_name = contact.getContactName();
			String C_mail = contact.getContactMail();
			String C_message = contact.getContactMessage();


			try {
				// jdbcドライバの読み込み（OracleDB）
				Class.forName("com.mysql.jdbc.Driver");
			
				//  DB接続
				db_con = DriverManager.getConnection(JDBC_url, DB_user, DB_pass);
			
				// 実行するSQL文をセット（空文字）
				String sql = "INSERT INTO contact(contactName, contactMail, contactMessage) VALUES(?, ?, ?)";
							
				// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
				PreparedStatement ps = db_con.prepareStatement(sql);

				// 登録するIDと名前をセットする
				ps.setString(1, C_name);
				ps.setString(2, C_mail);
				ps.setString(3, C_message);
				
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
}
