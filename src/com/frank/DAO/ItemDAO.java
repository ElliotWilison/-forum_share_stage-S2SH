package com.frank.DAO;

import java.util.List;

import com.frank.bean.Item;

public interface ItemDAO {
	public List<Item> findItemsByManager(int manager);

	public void addItem(Item item);

	public void deleteItem(int ItemID);

	public void updateItem(Item item);

	public Item findItemById(int itemID);
}
