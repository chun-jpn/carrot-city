package model;

import java.util.List;

import dao.ItemsDAO;

public class Itemslogic {
	public boolean execute (Items items)  {
		ItemsDAO itemsdao = new ItemsDAO();
		List<Items> itemsList = itemsdao.findAll();
	    return items != null;
	}
}
