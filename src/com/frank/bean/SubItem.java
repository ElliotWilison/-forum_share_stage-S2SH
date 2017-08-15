package com.frank.bean;

import java.util.Set;

public class SubItem {
	private int subItemID;
	private String subItemName;
	private int itemID;
	private String itemDescription;
	private User manager;
	private Set<Topic> topics;

	public int getSubItemID() {
		return subItemID;
	}

	public void setSubItemID(int subItemID) {
		this.subItemID = subItemID;
	}

	public String getSubItemName() {
		return subItemName;
	}

	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}



	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}
