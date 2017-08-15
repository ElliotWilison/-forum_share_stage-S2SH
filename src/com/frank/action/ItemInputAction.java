package com.frank.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.frank.bean.Item;
import com.frank.bean.User;
import com.frank.service.ItemService;
import com.frank.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInputAction extends ActionSupport {
	private ItemService itemService;
	private String itemName;
	private String itemDescription;
	private int itemID;
	

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public ItemService getItemService() {
		return itemService;
	}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	User user=(User)ServletActionContext.getRequest().getSession().getAttribute("User");
    if(itemID!=0){
    	itemService.deleteItem(itemID);
    	
    }
    
    List<Item> items=itemService.findItemsByManager(user.getUserID());
    if(itemName!=null)
    {
    Item item=new Item();
    item.setItemName(itemName);
    item.setItemDescription(itemDescription);
    item.setManager(user);
    itemService.saveItem(item);
    items.add(item);
    }
    ServletActionContext.getRequest().getSession().setAttribute("Items", items);
	ServletActionContext.getRequest().getSession().setAttribute("User", user);
	return "success";
}
}
