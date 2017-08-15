package com.frank.servicelmpl;

import java.util.List;

import com.frank.DAO.SubItemDAO;
import com.frank.bean.SubItem;
import com.frank.service.SubItemService;

public class SubItemServicelmpl implements SubItemService {

	private SubItemDAO subItemDAO;

	@Override
	public SubItemDAO getItemDAO() {
		// TODO Auto-generated method stub
		return subItemDAO;
	}

	@Override
	public void setSubItemDAO(SubItemDAO subItemDAO) {
		// TODO Auto-generated method stub
		this.subItemDAO = subItemDAO;

	}

	@Override
	public boolean saveSubItem(SubItem subItem) {
		// TODO Auto-generated method stub
		subItemDAO.addSubItem(subItem);
		return true;
	}

	@Override
	public boolean deleteSubItem(int subItemID) {
		// TODO Auto-generated method stub
		subItemDAO.deleteSubItem(subItemID);
		return true;
	}

	@Override
	public SubItem findSubItemById(int subItemID) {
		// TODO Auto-generated method stub
		SubItem subItem = subItemDAO.findSubItemById(subItemID);
		return subItem;
	}

	@Override
	public List<SubItem> findItemsByItemID(int itemID) {
		// TODO Auto-generated method stub
		List<SubItem> list = subItemDAO.findSubItemsByItemID(itemID);
		return list;
	}

	@Override
	public List<SubItem> findAllSubItem() {
		// TODO Auto-generated method stub
		List<SubItem> list = subItemDAO.findAllSubItem();
		return list;
	}

}
