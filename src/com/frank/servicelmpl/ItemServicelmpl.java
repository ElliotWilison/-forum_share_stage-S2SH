package com.frank.servicelmpl;

import java.util.List;

import com.frank.DAO.ItemDAO;
import com.frank.bean.Item;
import com.frank.service.ItemService;

public class ItemServicelmpl implements ItemService {
	private ItemDAO itemDAO;

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;

	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public List<Item> findItemsByManager(int manager) {
		List<Item> items = itemDAO.findItemsByManager(manager);
		return items;
	}

	public boolean saveItem(Item item) {
		itemDAO.addItem(item);
		return true;
	}

	public boolean deleteItem(int itemID) {
		itemDAO.deleteItem(itemID);
		return true;
	}

	public Item findItemById(int itemID) {
		Item item = itemDAO.findItemById(itemID);
		return item;
	}

}