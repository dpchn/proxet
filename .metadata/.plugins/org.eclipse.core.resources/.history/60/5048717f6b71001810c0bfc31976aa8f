package com.proxet.core.context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*public class HibernateSessionUtil {
	private Session session;
	private SessionFactory sessionFactory;
	
	private static HibernateSessionUtil factoryUtil;
	private HibernateSessionUtil(){
		
	}
	
	public static HibernateSessionUtil getSessionFactory(){
		if(factoryUtil==null)
			factoryUtil = new HibernateSessionUtil();
		return factoryUtil;
	}

	public Session openSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public void closeSessoin() {
		session.close();
	}
}
*/


public class HibernateSessionUtil {

	public static ThreadLocal<Session> threadLocalSession = new ThreadLocal<Session>();
	public static SessionFactory sessionFactory;
	private static HibernateSessionUtil factoryUtil;
	private HibernateSessionUtil(){
		
	}
	
	public static HibernateSessionUtil getSessionFactory(){
		if(factoryUtil==null)
			factoryUtil = new HibernateSessionUtil();
		return factoryUtil;
	}
	static {
		sessionFactory = new Configuration().configure("com/proxet/api/framework/hibernate.cfg.xml").buildSessionFactory();
	}

	
	public static Session openSession() {
		Session session = threadLocalSession.get();
		if (session == null) {
			session = sessionFactory.openSession();
			threadLocalSession.set(session);
		}
		return session;
	}

	public static void destroySession() {
		threadLocalSession.remove();
	}
	


}