package com.frank.action;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.User;
import com.frank.service.SubItemService;
import com.opensymphony.xwork2.ActionSupport;

public class SubItemInputAction extends ActionSupport {
	private SubItemService subItemService;

	private int itemID;
	private int subItemID;
	private String subItemName;
	private String subItemDescription;
	private int write;



	public int getSubItemID() {
		return subItemID;
	}

	public void setSubItemID(int subItemID) {
		this.subItemID = subItemID;
	}

	public int getWrite() {
		return write;
	}

	public void setWrite(int write) {
		this.write = write;
	}

	public String getSubItemName() {
		return subItemName;
	}

	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}

	public String getSubItemDescription() {
		return subItemDescription;
	}

	public void setSubItemDescription(String subItemDescription) {
		this.subItemDescription = subItemDescription;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public SubItemService getSubItemService() {
		return subItemService;
	}

	public void setSubItemService(SubItemService subItemService) {
		this.subItemService = subItemService;
	}
	@Override
	public String execute() throws Exception {
		String flag="success";
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("User");
		if(subItemID!=0)
		{
			subItemService.deleteSubItem(subItemID);
		}
		List<SubItem> subItems=subItemService.findItemsByItemID(itemID);
		if(write==1)
		{
			List<SubItem> sItems=subItemService.findAllSubItem();
			ServletActionContext.getRequest().getSession().setAttribute("SItems", sItems);
			return "all";
		}
		
		if(itemID!=0)
		ServletActionContext.getRequest().getSession().setAttribute("itemID", itemID);
		else
		
			itemID=Integer.parseInt( ServletActionContext.getRequest().getSession().getAttribute("itemID").toString());
		if(subItemName!=null){
			SubItem si=new SubItem();
			si.setItemID(itemID);
			si.setManager(user);
			si.setSubItemName(subItemName);
			si.setItemDescription(subItemDescription);
			subItemService.saveSubItem(si);
			subItems.add(si);
			flag="input";
		}
	
        List<Item> items=(List<Item>) ServletActionContext.getRequest().getSession().getAttribute("Items");
        ServletActionContext.getRequest().getSession().setAttribute("Items", items);
		ServletActionContext.getRequest().getSession().setAttribute("SubItems", subItems);
		ServletActionContext.getRequest().getSession().setAttribute("User", user);
		return flag;
	}

}
