package test;

import java.util.List;

import dao.ItemsDAO;
import model.Items;



public class ItemsDAOTest {
	public static void main(String[] args) {
		
		ItemsDAO itemsDAO = new ItemsDAO();
		List<Items> itemsList = itemsDAO.findAll();
		
		
		for(Items items : itemsList) {
			System.out.println("ID:" + items.getItem_id());
			System.out.println("カテゴリー:" + items.getCategory());
			System.out.println("商品名:" + items.getItem_name());
			System.out.println("価格:" + items.getPrice());
			System.out.println("コメント:" + items.getComment());
			System.out.println("公開・非公開:" + items.getRelease_flag());
			System.out.println("登録日:" + items.getAdd_date());
			System.out.println("更新日:" + items.getRewrite_date());
			System.out.println("画像:" + items.getPicture());
			
		}
	}
}
