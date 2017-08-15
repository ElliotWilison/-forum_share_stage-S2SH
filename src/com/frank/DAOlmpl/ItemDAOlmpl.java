package com.frank.DAOlmpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frank.DAO.ItemDAO;
import com.frank.bean.Item;
import com.frank.sessionfcty.HibernateSessionFactory;

public class ItemDAOlmpl implements ItemDAO {

	public List<Item> findItemsByManager(int manager) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Item where manager=" + manager;
		List<Item> list = session.createQuery(hql).list();
		HibernateSessionFactory.closeSession();
		return list;

	}

	public void addItem(Item item) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public void deleteItem(int ItemID) {
		
		Session session = HibernateSessionFactory.getSession();
		Item item=(Item)session.load(com.frank.bean.Item.class, ItemID);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(item);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public void updateItem(Item item) {

		Session session = HibernateSessionFactory.getSession();
//		Item i=(Item)session.load(com.frank.bean., arg1)
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(item);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public Item findItemById(int itemID) {
		Session session = HibernateSessionFactory.getSession();
		Object oj = session.load(com.frank.bean.Item.class, itemID);
		Item item = (Item) oj;
		HibernateSessionFactory.closeSession();
		return item;

	}
}
