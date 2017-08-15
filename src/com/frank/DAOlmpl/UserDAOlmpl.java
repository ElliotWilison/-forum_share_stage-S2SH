package com.frank.DAOlmpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frank.DAO.UserDAO;
import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.bean.Topic;
import com.frank.bean.User;
import com.frank.sessionfcty.HibernateSessionFactory;

public class UserDAOlmpl implements UserDAO {

	@Override
	public User getUser(String username, String pwd) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where username='" + username + "' and password='" + pwd+"'";
		Query query = session.createQuery(hql);
		List<User> list=query.list();
		User user  = list.get(0);
		HibernateSessionFactory.closeSession();
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public List<Item> getUserItemsByUserId(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Item where manager=" +id;
		Query query = session.createQuery(hql);
		List<Item> list=query.list();
		return list;
	}

	@Override
	public List<SubItem> getSubItemsByUserId(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from SubItem where manager=" +id;
		Query query = session.createQuery(hql);
		List<SubItem> list=query.list();
		return list;
	}

	@Override
	public List<Topic> getTopicsByUserId(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Topic where user=" +id;
		Query query = session.createQuery(hql);
		List<Topic> list=query.list();
		return list;
	}

}
