package model;

public class Items {
	private int item_id;
	private String category;
	private String item_name;
	private int price;
	private String comment;
	private int stock;
	private int release_flag;
	private String add_date;
	private String rewrite_date;
	private String picture;
	private int totalQuantity;
	
	//アイテム検索用
	public Items(int item_id,String category,String item_name,
	int price, String comment,int stock,int release_flag,String add_date,
	String rewrite_date,String picture) {
		this.item_id = item_id;
		this.category = category;
		this.item_name = item_name;
		this.price = price;
		this.comment = comment;
		this.stock = stock;
		this.release_flag = release_flag;
		this.add_date = add_date;
		this.rewrite_date = rewrite_date;
		this.picture = picture;
	}
	
//	アイテム追加用
	public Items(String category, String item_name,
	int price, String comment,int stock,int release_flag,String picture) {
		this.category = category;
		this.item_name = item_name;
		this.price = price;
		this.comment = comment;
		this.stock = stock;
		this.release_flag = release_flag;
		this.picture = picture;
	}
	
//	ランキング表示表
	public Items(int item_id, String item_name,int price, String picture, int totalQuantity) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
		this.picture = picture;
		this.totalQuantity = totalQuantity;
		
	}
	public int getItem_id() {return item_id;}
	public String getCategory() {return category;}
	public String getItem_name() {return item_name;}
	public int getPrice() {return price;}
	public String getComment() {return comment;}
	public int getStock() {return stock;}
	public int getRelease_flag() {return release_flag;}
	public String getAdd_date() {return add_date;}
	public String getRewrite_date() {return rewrite_date;}
	public String getPicture() {return picture;}
	public int getTotalQuantity() {return totalQuantity;}

	
	
}
