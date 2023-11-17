package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Items;

@WebServlet("/ProductChangeNGServlet")
public class ProductChangeNGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// セッションスコープからアイテムを取得
		Items item = (Items) session.getAttribute("items");
		Part newPicture = (Part) session.getAttribute("newPicture");
		int itemId = item.getItem_id();
		
		
		if (newPicture != null && newPicture.getSize() > 0) {
			if (item != null) {
				
			    // アイテムが存在する場合、ファイル名を取得
			    String fileName = item.getPicture();
	
			    if (fileName != null) {
			        // 画像ファイルの保存先ディレクトリ
			        String uploadDir = "C:\\carrot-city\\xmasTown\\src\\main\\webapp\\itemImage";
	
			        // 画像ファイルのフルパスを生成
			        String filePath = uploadDir + File.separator + fileName;
	
			        // Fileオブジェクトを生成
			        File file = new File(filePath);
	
			        // ファイルが存在するか確認し、存在する場合は削除
			        if (file.exists()) {
			            if (file.delete()) {
			                System.out.println("画像ファイル " + fileName + " が削除されました。");
			            } else {
			                System.err.println("画像ファイル " + fileName + " の削除に失敗しました。");
			            }
			        } else {
			            System.err.println("画像ファイル " + fileName + " が見つかりません。");
			        }
			    } else {
			        System.err.println("セッションスコープが見つかりません。");
			    }
			}
		}
		
		
		// item_idの情報を渡しながらリダイレクト
		response.sendRedirect("ProductDetailServlet?item_id=" + itemId);
	}

}
