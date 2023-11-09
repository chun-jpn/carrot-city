package model;

public class Carts {
	private int user_id;
	private int item_id;
	private int price;
	private int quantity;
	
	public Carts(int user_id, int item_id,
			int price,int quantity) {
		this.user_id = user_id;
		this.item_id = item_id;
		this.price = price;
		this.quantity = quantity;
	}
	public int getUser_id() {return user_id;}
	public int getItem_id() {return item_id;}
	public int getPrice() {return price;}
	public int getQuantity() {return quantity;}
}
