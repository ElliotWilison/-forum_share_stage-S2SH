package com.frank.service;

import java.util.List;

import com.frank.DAO.UserDAO;
import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;

public interface UserService {

	public UserDAO getUserDAO();

	public void setUserDAO(UserDAO userDAO);

	public User getUser(String username, String pwd);

	public boolean saveUser(User user);
	
    public List<Item> getUserItemsByUserId(int id);
	
	public List<SubItem> getSubItemsByUserId(int id);
	
	public List<Topic> getTopicByUserId(int id);
}
