package com.frank.servicelmpl;

import java.util.List;

import com.frank.DAO.UserDAO;
import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;
import com.frank.service.UserService;

public class UserServicelmpl implements UserService {

	private UserDAO userDAO;

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return userDAO;
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		// TODO Auto-generated method stub
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String username, String pwd) {
		// TODO Auto-generated method stub
		User user = userDAO.getUser(username, pwd);

		return user;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
		return true;
	}

	@Override
	public List<Item> getUserItemsByUserId(int id) {
		// TODO Auto-generated method stub
		List<Item> list=userDAO.getUserItemsByUserId(id);
		return list;
	}

	@Override
	public List<SubItem> getSubItemsByUserId(int id) {
		// TODO Auto-generated method stub
		List<SubItem> list=userDAO.getSubItemsByUserId(id);
		return list;
	}

	@Override
	public List<Topic> getTopicByUserId(int id) {
		// TODO Auto-generated method stub
		List<Topic> list=userDAO.getTopicsByUserId(id);
		return list;
	}

}
