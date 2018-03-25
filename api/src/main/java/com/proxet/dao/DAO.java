package com.proxet.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.proxet.core.context.AppContext;

public class DAO<T> {

	protected Session getSession(){
		return AppContext.get().openSession();
	}
	
	
	/*protected void closeSessoin(){
		 AppContext.get().closeSession();
	}*/

	public int save(T object){
		Transaction transaction;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			transaction.begin();
			Serializable objectId = session.save(object);
			transaction.commit();
			session.flush();
			return (int)objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}
	
	
}
