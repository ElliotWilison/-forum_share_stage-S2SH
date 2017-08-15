package com.frank.service;

import java.util.List;

import com.frank.DAO.SubItemDAO;
import com.frank.bean.SubItem;

public interface SubItemService {
	public SubItemDAO getItemDAO();

	public void setSubItemDAO(SubItemDAO subItemDAO);

	public boolean saveSubItem(SubItem subItem);

	public boolean deleteSubItem(int subItemID);

	public SubItem findSubItemById(int subItemID);

	public List<SubItem> findItemsByItemID(int itemID);
	
	public List<SubItem> findAllSubItem();
}
