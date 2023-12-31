package model;

public class Carts {
	private int cart_id;
	private String mail;
	private int item_id;
	private int price;
	private int quantity;
	private String item_name;
	private String picture;
	private int stock;
	
	public Carts(String mail, int item_id,int price,int quantity) {
		this.mail = mail;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Carts(int cart_id, String mail, int item_id,int price,int quantity, String item_name, String picture, int stock) {
		this.cart_id = cart_id;
		this.mail = mail;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
		this.item_name = item_name;
		this.picture = picture;
		this.stock = stock;
	}
	
	public int getCart_id() {return cart_id;}
	public String getMail() {return mail;}
	public int getItem_id() {return item_id;}
	public int getPrice() {return price;}
	public int getQuantity() {return quantity;}
	public String getItem_name() {return item_name;}
	public String getPicture() {return picture;}
	public int getStock() {	return stock;}



	
}
