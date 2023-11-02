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
		int price = Integer.parseInt(request.getParameter("price"));
		String comment = request.getParameter("comment");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int releaseFlag = Integer.parseInt(request.getParameter("releaseFlag"));
//		String picture = request.getParameter("picture");
		
//		画像のアップロード処理
		Part filePart = request.getPart("picture");
		String picture = uploadFile(filePart);

//		filePart確認用
		System.out.println(filePart);
		
//		Itemsインスタンスの生成
		Items items = new Items(category, itemName, price, comment, quantity, releaseFlag, picture);
//		リクエストスコープに保存
		request.setAttribute("item", items);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/addItemConfirm.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private String uploadFile(Part filePart) {
        String fileName = "";
        try {
            String contentType = filePart.getContentType();
            if (contentType != null && contentType.startsWith("image")) {
                // 一意のファイル名を生成
                String uniqueFileName = UUID.randomUUID().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String timestamp = sdf.format(new Date());
                fileName = uniqueFileName + timestamp;

                // 画像ファイルの保存先ディレクトリ
//              String uploadDir = "../webapp/itemImage";
                String uploadDir = getServletContext().getRealPath("/itemImage");
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
//              保存先フォルダ確認用
                System.out.println(uploadDir);
                
                // ファイルを保存
                String savePath = uploadDir + File.separator + fileName;
                filePart.write(savePath);
                
                //ファイル名確認用
                System.out.println(fileName);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
