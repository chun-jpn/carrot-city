package model;

public class Orders {
	private int order_id;
	private int user_id;
	private int item_id;
	private int quantity;
	private int total_price;
	
	
	public Orders(int order_id,int user_id,
			int item_id,int quantity, int total_price) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.total_price = total_price;
	}
	public int getOrder_id() {return order_id;}
	public int getUser_id() {return user_id;}
	public int getItem_id() {return item_id;}
	public int getQuantity() {return quantity;}
	public int getTotal_price() {return total_price;}
}
