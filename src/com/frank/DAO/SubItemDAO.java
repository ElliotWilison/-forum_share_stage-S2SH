package com.frank.DAO;

import java.util.List;

import com.frank.bean.SubItem;

public interface SubItemDAO {
	public List<SubItem> findSubItemsByItemID(int itemID);

	public void addSubItem(SubItem subItem);

	public void deleteSubItem(int subItemID);

	public void updateSubItem(SubItem subItem);

	public SubItem findSubItemById(int subItemID);
	public List<SubItem> findAllSubItem();
}
