package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class ItemsDAO {
  private final String JDBC_URL =
      "jdbc:mysql://localhost:3306/xmas_town?charaxterEncoding=UTF-8&serverTimezone=JST";
  private final String DB_USER = "root";
  private final String DB_PASS = "";

  // アイテム新規登録用メソッド
  public void addItem(Items items) {
    // 初期値を入手
    Connection db_con = null;
    String category = items.getCategory();
    String item_name = items.getItem_name();
    int price = items.getPrice();
    String comment = items.getComment();
    int stock = items.getStock();
    int release_flag = items.getRelease_flag();
    String picture = items.getPicture();

    try {
      // jdbcドライバの読み込み（OracleDB）
      Class.forName("com.mysql.jdbc.Driver");

      // DB接続
      db_con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

      // 実行するSQL文をセット（空文字）
      String sql =
          "INSERT INTO items(category, item_name, price, comment, stock, release_flag, add_date, rewrite_date, picture) VALUES(?, ?, ?, ?, ?, ? ,? ,? ,?)";

      // DBで実行するSQL文を「prepareStatement」インスタンスに格納する
      PreparedStatement ps = db_con.prepareStatement(sql);

      // 登録するIDと名前をセットする
      ps.setString(1, category);
      ps.setString(2, item_name);
      ps.setInt(3, price);
      ps.setString(4, comment);
      ps.setInt(5, stock);
      ps.setInt(6, release_flag);
      Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
      ps.setTimestamp(7, currentTimestamp);
      ps.setTimestamp(8, currentTimestamp);
      ps.setString(9, picture);
      // SQL実行
      ps.executeUpdate();

    } catch (SQLException sql_e) {
      System.out.println("SQL実行中にエラーが発生しました: " + sql_e.getMessage());
      sql_e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("JDBCドライバ関連エラー: " + e.getMessage());
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

//商品情報更新用メソッド
 public void productChange(Items items) {
   // 初期値を入手
   Connection db_con = null;
   int item_id = items.getItem_id();
   String category = items.getCategory();
   String item_name = items.getItem_name();
   int price = items.getPrice();
   String comment = items.getComment();
   int stock = items.getStock();
   int release_flag = items.getRelease_flag();
   String picture = items.getPicture();

   try {
     // jdbcドライバの読み込み（OracleDB）
     Class.forName("com.mysql.jdbc.Driver");

     // DB接続
     db_con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

     // 実行するSQL文をセット（空文字）
     String sql =
         "update items set category=?, item_name=?, price=?, comment=?, stock=?, release_flag=?, rewrite_date=?, picture=? where item_id=?";

     // DBで実行するSQL文を「prepareStatement」インスタンスに格納する
     PreparedStatement ps = db_con.prepareStatement(sql);

     // 登録するIDと名前をセットする
     ps.setString(1, category);
     ps.setString(2, item_name);
     ps.setInt(3, price);
     ps.setString(4, comment);
     ps.setInt(5, stock);
     ps.setInt(6, release_flag);
     Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
     ps.setTimestamp(7, currentTimestamp);
     ps.setString(8, picture);
     ps.setInt(9, item_id);
     // SQL実行
     ps.executeUpdate();

   } catch (SQLException sql_e) {
     System.out.println("SQL実行中にエラーが発生しました: " + sql_e.getMessage());
     sql_e.printStackTrace();
   } catch (ClassNotFoundException e) {
     System.out.println("JDBCドライバ関連エラー: " + e.getMessage());
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
  
  // カテゴリ検索
  public List<Items> findByCategory(String cSearch) {
    List<Items> itemsList = new ArrayList<Items>();
    // JDBCドライバを読み込む
    try {
      String drivername = "com.mysql.jdbc.Driver";
      Class.forName(drivername);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }
    // データベース接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備

      // String sql = "select * from items";
      String sql = "select * from items where category = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, cSearch);
      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int itemId = rs.getInt("item_id");
        String category = rs.getString("category");
        String itemName = rs.getString("item_name");
        int price = rs.getInt("price");
        String comment = rs.getString("comment");
        int stock = rs.getInt("stock");
        int releaseFlag = rs.getInt("release_flag");
        String addDate = rs.getString("add_date");
        String rewriteDate = rs.getString("rewrite_date");
        String picture = rs.getString("picture");
        Items items = new Items(itemId, category, itemName, price, comment, stock, releaseFlag,
            addDate, rewriteDate, picture);
        itemsList.add(items);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return itemsList;
  }

  // 商品詳細
  public Items selectById(String item_id) {
    Items items = null;

    // JDBCドライバを読み込む
    try {
      String drivername = "com.mysql.jdbc.Driver";
      Class.forName(drivername);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }

    // データベース接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備

      // String sql = "select * from items";
      String sql = "SELECT * FROM items WHERE item_id = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, item_id);
      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();


      // SELECT文の結果をArrayListに格納
      if (rs.next()) {
        int itemId = rs.getInt("item_id");
        String category = rs.getString("category");
        String itemName = rs.getString("item_name");
        int price = rs.getInt("price");
        String comment = rs.getString("comment");
        int stock = rs.getInt("stock");
        int releaseFlag = rs.getInt("release_flag");
        String addDate = rs.getString("add_date");
        String rewriteDate = rs.getString("rewrite_date");
        String picture = rs.getString("picture");
        items = new Items(itemId, category, itemName, price, comment, stock, releaseFlag, addDate,
            rewriteDate, picture);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return items;
  }

  // 商品名検索
  public List<Items> search(String item_name) {
    List<Items> itemsList = new ArrayList<Items>();

    // JDBCドライバを読み込む
    try {
      String drivername = "com.mysql.jdbc.Driver";
      Class.forName(drivername);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }
    // データベース接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql = "SELECT * FROM items WHERE item_name LIKE ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, "%" + item_name + "%");

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int itemId = rs.getInt("item_id");
        String category = rs.getString("category");
        String itemName = rs.getString("item_name");
        int price = rs.getInt("price");
        String comment = rs.getString("comment");
        int stock = rs.getInt("stock");
        int releaseFlag = rs.getInt("release_flag");
        String addDate = rs.getString("add_date");
        String rewriteDate = rs.getString("rewrite_date");
        String picture = rs.getString("picture");
        Items items = new Items(itemId, category, itemName, price, comment, stock, releaseFlag,
            addDate, rewriteDate, picture);
        itemsList.add(items);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return itemsList;
  }

  // 商品売却時、ストックマイナスメソッド
  public void decStock(int quantity, int item_id) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }


    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      // select文の準備
      String getSql = "SELECT stock FROM items WHERE item_id = ?";
      PreparedStatement getPStmt = conn.prepareStatement(getSql);
      getPStmt.setInt(1, item_id);
      // SELECTを実行
      ResultSet rs = getPStmt.executeQuery();
      if (rs.next()) {
        int stock = rs.getInt("stock");
        int decStock = stock - quantity;

        // update文の準備
        String upSql = "UPDATE items SET stock = ? WHERE item_id = ?";
        PreparedStatement upPStmt = conn.prepareStatement(upSql);
        upPStmt.setInt(1, decStock);
        upPStmt.setInt(2, item_id);

        // SQL実行
        upPStmt.executeUpdate();
      } else {
        // エラー処理: 指定したitem_idの商品が見つからなかった場合の処理
        System.err.println("指定したitem_idの商品が見つかりませんでした。");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  // おすすめ商品、ランダム表示
  public List<Items> randById() {
    List<Items> itemsList = new ArrayList<Items>();

    // JDBCドライバを読み込む
    try {
      String drivername = "com.mysql.jdbc.Driver";
      Class.forName(drivername);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }

    // データベース接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備

      String sql = "SELECT * FROM items ORDER BY RAND() LIMIT 4";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // pStmt.setInt();
      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();


      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int itemId = rs.getInt("item_id");
        String category = rs.getString("category");
        String itemName = rs.getString("item_name");
        int price = rs.getInt("price");
        String comment = rs.getString("comment");
        int stock = rs.getInt("stock");
        int releaseFlag = rs.getInt("release_flag");
        String addDate = rs.getString("add_date");
        String rewriteDate = rs.getString("rewrite_date");
        String picture = rs.getString("picture");
        Items items = new Items(itemId, category, itemName, price, comment, stock, releaseFlag,
            addDate, rewriteDate, picture);
        itemsList.add(items);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return itemsList;
  }

  // 商品削除メソッド
  public void deleteItem(int item_id) {
    // JDBCドライバを読み込む
    try {
      String drivername = "com.mysql.jdbc.Driver";
      Class.forName(drivername);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }

    // データベース接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      // DELETE文の準備
      String sql = "DELETE FROM items WHERE item_id=?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setInt(1, item_id);
      int affectedRows = pStmt.executeUpdate();

      // データベース接続を閉じる
      conn.close();

      // 削除確認
      if (affectedRows > 0) {
        // 削除が成功した場合の処理
        System.out.println("商品の削除に成功しました");
      } else {
        // 削除が失敗した場合の処理
        System.out.println("商品の削除に失敗しました");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}

