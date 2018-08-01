package com.proxet.core.context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.proxet.api.dao.DAO;

public class AppContext {
	// private static final Logger logger =
	// Logger.getPlatformLogger(AppContext.class);
	protected static ThreadLocal<AppContext> appContextThreadLocal = new ThreadLocal<>();
	protected static AppContext appContext;
	public Session session;
	private static SessionFactory sessionFactory;
	protected static Class<? extends AppContext> appContextClass;

	/*static{
		create();
	}
	public static AppContext create() {
		AppContext appContext;
		try {
			appContext = appContextClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Error initiating " + appContextClass, e);
		}
		appContext.session = appContext.openSession();
		appContextThreadLocal.set(appContext);
		return appContext;
	}*/

	public static AppContext get() {
		if (appContext == null)
			appContext = new AppContext();
		return appContext;
	}
	
	public <T extends DAO> T getDAO(Class<T> daoclass) {
		return DAOFactory.getDAO(daoclass);
	}
	
	public Session openSession(){
		return HibernateSessionUtil.getSessionFactory().openSession();
	}
	
	public void closeSession(){
		HibernateSessionUtil.getSessionFactory().destroySession();
	}
	
}
