package model;

public class Carts {
	private String mail;
	private int item_id;
	private int price;
	private int quantity;
	private String item_name;
	private String picture;
	
	public Carts(String mail, int item_id,int price,int quantity) {
		this.mail = mail;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Carts(String mail, int item_id,int price,int quantity, String item_name, String picture) {
		this.mail = mail;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
		this.item_name = item_name;
		this.picture = picture;
	}
	public String getMail() {return mail;}
	public int getItem_id() {return item_id;}
	public int getPrice() {return price;}
	public int getQuantity() {return quantity;}
	public String getItem_name() {return item_name;}
	public String getPicture() {return picture;}

	
}
