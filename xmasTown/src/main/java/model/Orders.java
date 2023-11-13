package model;

public class Orders {
//	private int order_id;
	private String mail;
	private int item_id;
	private int quantity;
	private String order_date;
	
	
	
	public Orders(String mail,
			int item_id,int quantity) {
//		this.order_id = order_id;
		this.mail = mail;
		this.item_id = item_id;
		this.quantity = quantity;
		this.order_date = order_date;
	
	}
//	public int getOrder_id() {return order_id;}
	public String getMail() {return mail;}
	public int getItem_id() {return item_id;}
	public int getQuantity() {return quantity;}
	public String getOrder_date() {return order_date;}
}
