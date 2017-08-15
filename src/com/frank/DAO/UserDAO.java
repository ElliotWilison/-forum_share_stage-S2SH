package com.frank.DAO;

import java.util.List;

import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;

public interface UserDAO {

	public User getUser(String username, String pwd);

	public void addUser(User user);
	
	public List<Item> getUserItemsByUserId(int id);
	
	public List<SubItem> getSubItemsByUserId(int id);
	
	public List<Topic> getTopicsByUserId(int id);

}
