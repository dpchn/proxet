package com.proxet.api.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.proxet.api.model.Company;
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
		//	session.close();
			return (int) objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Object find(T object, Serializable id){
		try{
			Session session = getSession();
			T objectId = (T) session.load(object.getClass(), id);
			session.flush();
		//	session.close();
			return objectId;
		}catch (Exception e) {
			System.out.println("Exception while company find"+e);
			throw e;
		}
	}
	
	public boolean update(T object){
		Transaction transaction;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			transaction.begin();
			session.update(object);;
			transaction.commit();
			session.flush();
			session.close();
			return true;
		}catch (Exception e) {
			System.out.println("Exception while update company"+e);
			return false;
		}
	}
}
