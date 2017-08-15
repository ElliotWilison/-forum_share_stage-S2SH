package com.frank.DAOlmpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frank.DAO.SubItemDAO;
import com.frank.bean.Item;
import com.frank.bean.SubItem;
import com.frank.sessionfcty.HibernateSessionFactory;

public class SubItemDAOlmpl implements SubItemDAO {



	@Override
	public void addSubItem(SubItem subItem) {
		// TODO Auto-generated method stub

		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(subItem);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void deleteSubItem(int subItemID) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		SubItem subItem = (SubItem) session.load(com.frank.bean.SubItem.class, subItemID);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(subItem);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void updateSubItem(SubItem subItem) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(subItem);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public SubItem findSubItemById(int subItemID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Object oj = session.load(com.frank.bean.SubItem.class, subItemID);
		SubItem subItem = (SubItem) oj;
		HibernateSessionFactory.closeSession();
		return subItem;
	}

	@Override
	public List<SubItem> findSubItemsByItemID(int itemID) {
		// TODO Auto-generated method stub
		String hql = "from SubItem where itemID=" + itemID;
		Session session = HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		List<SubItem> list=query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public List<SubItem> findAllSubItem() {
		// TODO Auto-generated method stub
		String hql = "from SubItem";
		Session session = HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		List<SubItem> list=query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
