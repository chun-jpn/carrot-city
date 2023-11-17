package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Items;


@WebServlet("/ProductChangeServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,  // 1MB
	    maxFileSize = 1024 * 1024 * 10,   // 10MB
	    maxRequestSize = 1024 * 1024 * 50  // 50MB
	)


public class ProductChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		登録内容変更プログラム
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String itemName = request.getParameter("itemName");	
		int price = Integer.parseInt(request.getParameter("price"));
		String comment = request.getParameter("comment");	
		int stock = Integer.parseInt(request.getParameter("stock"));
		int release_flag = Integer.parseInt(request.getParameter("releaseFlag"));
		String picture = "";
		
//		postで投げられてくる画像情報を取得
		Part newPicture = request.getPart("picture");
		
//		セッションに保存してある古い画像データを取得
		HttpSession session = request.getSession();
		Items items = (Items) session.getAttribute("items");
		String oldPicture = items.getPicture();

		if(newPicture != null) {//newPictureがnullでない場合
//			pictureに新しい画像が指定されている場合は新しい画像を登録
//			画像のアップロード処理
			picture = uploadFile(newPicture);
		} else {
//			pictureがnullの場合はセッションから既存の画像を取得する
			picture = oldPicture;
		}
		
		//新しいItemsインスタンスの生成
		items = new Items(category, itemName, price, comment, stock, release_flag, picture);
//		セッションに情報を投げる
		session.setAttribute("items", items);
		session.setAttribute("newPicture", newPicture);
		session.setAttribute("oldPicture", oldPicture);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChange.jsp");
		dispatcher.forward(request, response);
	}

	
	//画像ファイル保存メソッド
	String uploadFile(Part filePart) {
	    String fileName = "";
	    try {
	        String contentType = filePart.getContentType();
	        if (contentType != null && contentType.startsWith("image")) {
	        	// 拡張子を取得
	        	String fileExtension = getExtension(filePart);
	        	
	            // 一意のファイル名を生成
	            String uniqueFileName = UUID.randomUUID().toString();
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	            String timestamp = sdf.format(new Date());
	//			fileName = uniqueFileName + timestamp;
				fileName = uniqueFileName + timestamp + "." + fileExtension;
	
	            // 画像ファイルの保存先ディレクトリ
	//          String uploadDir = "../webapp/itemImage";
	//            String uploadDir = getServletContext().getRealPath("/itemImage");
	            String uploadDir = "C:\\carrot-city\\xmasTown\\src\\main\\webapp\\itemImage";
	            
				File dir = new File(uploadDir);
				if (!dir.exists()) {
				dir.mkdirs();
				}
	            
	            // ファイルを保存
	            String savePath = uploadDir + File.separator + fileName;
	            filePart.write(savePath);
	            
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return fileName;
	}


	//拡張子取得メソッド
	private String getExtension(Part filePart) {
	    String header = filePart.getHeader("content-disposition");
	    String[] headerParts = header.split(";");
	    for (String headerPart : headerParts) {
	        if (headerPart.trim().startsWith("filename")) {
	            String fileName = headerPart.substring(headerPart.indexOf('=') + 1).trim();
	            // ファイル名に含まれる二重引用符を削除
	            fileName = fileName.replaceAll("\"", "");
	            return fileName.substring(fileName.lastIndexOf('.') + 1);
	        }
	    }
	    return "";
	}
}