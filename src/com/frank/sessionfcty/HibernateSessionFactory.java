package com.frank.sessionfcty;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	public static String confile = "/hibernate.cfg.xml";
	public static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	public static Configuration configuration = new Configuration();
	public static org.hibernate.SessionFactory sessionfactory;
	static {

		try {
			configuration.configure(confile);
			sessionfactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("%%Error!!!%");
			e.printStackTrace();
		}
	}

	public static Session getSession() throws HibernateException {
		Session session = (Session) threadlocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionfactory == null) {

			}
			session = (sessionfactory != null) ? sessionfactory.openSession() : null;
			threadlocal.set(session);
		}
		return session;
	}

	public static void rebuildSession() throws HibernateException {
		try {
			configuration.configure(confile);
			sessionfactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("%%Error!!!%");
			e.printStackTrace();
		}

	}

	public static void closeSession() throws HibernateException {
		Session session = threadlocal.get();
		threadlocal.set(null);
		if (session != null) {
			session.close();
		}
	}

}
