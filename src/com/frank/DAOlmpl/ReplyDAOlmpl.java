package com.frank.DAOlmpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frank.DAO.ReplyDAO;
import com.frank.bean.Reply;
import com.frank.bean.Topic;
import com.frank.sessionfcty.HibernateSessionFactory;

public class ReplyDAOlmpl implements ReplyDAO {

	@Override
	public List<Reply> findReplyByTopicID(int topicID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Reply where topicID=" + topicID;
		List<Reply> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(reply);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void deleteReply(int Id) {
		// TODO Auto-generated method stub
		String hql = "from Reply where Id=" + Id;
		Session session = HibernateSessionFactory.getSession();
		Reply reply = (Reply) session.createQuery(hql);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(reply);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@Override
	public Reply findReplyById(int Id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Object oj = session.load(com.frank.bean.Reply.class, Id);
		Reply reply = (Reply) oj;
		return reply;
	}

	@Override
	public Topic findTopicById(int topicID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Object oj = session.load(com.frank.bean.Topic.class, topicID);
		Topic topic=(Topic)oj;
		return topic;
	}

}
