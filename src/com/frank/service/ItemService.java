package com.frank.service;

import java.util.List;

import com.frank.DAO.ItemDAO;
import com.frank.bean.Item;

public interface ItemService {
	public ItemDAO getItemDAO();

	public void setItemDAO(ItemDAO itemdao);

	public boolean saveItem(Item item);

	public boolean deleteItem(int itemID);

	public Item findItemById(int itemID);

	public List<Item> findItemsByManager(int manager);
}
