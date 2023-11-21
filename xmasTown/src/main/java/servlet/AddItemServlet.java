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



/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,  // 1MB
	    maxFileSize = 1024 * 1024 * 10,   // 10MB
	    maxRequestSize = 1024 * 1024 * 50  // 50MB
	)
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItem.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String itemName = request.getParameter("itemName");
		String s_price = request.getParameter("price");
		String comment = request.getParameter("comment");
		String s_stock = request.getParameter("stock");
		String s_releaseFlag = request.getParameter("releaseFlag");
//		String picture = request.getParameter("picture");
		
		if (category.isEmpty() || itemName.isEmpty() || s_price.isEmpty() || comment.isEmpty() || s_stock.isEmpty() || s_releaseFlag.isEmpty()) {
			// エラーメッセージをセットしてフォームを再表示
			request.setAttribute("error", "入力していない項目があります。全て入力してから登録ボタンを押してください");
			request.getRequestDispatcher("WEB-INF/jsp/addItem.jsp").forward(request, response);
			System.out.println("入力していない項目があります");
		}else {
		int price = Integer.parseInt(s_price);
		int stock = Integer.parseInt(s_stock);
		int releaseFlag = Integer.parseInt(s_releaseFlag);
		
//		画像のアップロード処理
			Part filePart = request.getPart("picture");
			String picture = uploadFile(filePart);

//		filePart確認用
			System.out.println(picture);
		
			if(picture.isEmpty()) {
				picture = "noimage.png";
			}
			
		
//		Itemsインスタンスの生成
			Items items = new Items(category, itemName, price, comment, stock, releaseFlag, picture);
		
//		セッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("item", items);
		

		// リダイレクト
			response.sendRedirect("AddItemFakeServlet");
		
		
		// フォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItemConfirm.jsp");
//		dispatcher.forward(request, response);
		}
	}
	
//	画像ファイル保存メソッド
	private String uploadFile(Part filePart) {
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
//				fileName = uniqueFileName + timestamp;
				fileName = uniqueFileName + timestamp + "." + fileExtension;

                // 画像ファイルの保存先ディレクトリ
//				String uploadDir = "../webapp/itemImage";
//				String uploadDir = getServletContext().getRealPath("/itemImage");
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
	
//	private String getExtension(Part filePart) {
//	    String header = filePart.getHeader("content-disposition");
//	    for (String headerPart : header.split(";")) {
//	        if (headerPart.trim().startsWith("filename")) {
//	            String fileName = headerPart.substring(headerPart.lastIndexOf('\\') + 1);
//	            return fileName.substring(fileName.lastIndexOf('.') + 1);
//	        }
//	    }
//	    return "";
//	}
	
//	拡張子取得メソッド
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
