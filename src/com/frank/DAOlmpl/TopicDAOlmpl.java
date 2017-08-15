package com.frank.DAOlmpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frank.DAO.TopicDAO;
import com.frank.bean.Topic;
import com.frank.sessionfcty.HibernateSessionFactory;

public class TopicDAOlmpl implements TopicDAO {

	@Override
	public List<Topic> findTopicsBySubItemID(int subItemID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Topic where subItemID=" + subItemID;
		Query query=session.createQuery(hql);
		List<Topic> list = query.list();
//		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(topic);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void deleteTopic(int topicID) {
		// TODO Auto-generated method stub
	
		Session session = HibernateSessionFactory.getSession();
		Topic topic = (Topic) session.load(com.frank.bean.Topic.class,topicID);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(topic);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Topic t=(Topic)session.load(com.frank.bean.Topic.class, topic.getTopicID());
		t.setContent(topic.getContent());
		t.setSubItemID(topic.getSubItemID());
		t.setTopic(topic.getTopic());
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public Topic findTopicById(int topicID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Object oj = session.load(com.frank.bean.Topic.class, topicID);
		Topic topic = (Topic) oj;
//		HibernateSessionFactory.closeSession();
		return topic;
	}

	@Override
	public List<Topic> findAllTopics() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Topic";
		Query query=session.createQuery(hql);
		List<Topic> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public List<Topic> findTopicsbByKetWords(String keyWords) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Topic where topic like '%"+keyWords+"%'";
		Query query=session.createQuery(hql);
		List<Topic> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
