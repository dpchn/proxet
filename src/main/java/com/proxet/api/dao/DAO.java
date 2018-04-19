package com.proxet.api.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.proxet.api.model.Company;
import com.proxet.core.context.AppContext;

public class DAO<T> {

	private Session getSession(){
		return AppContext.get().openSession();
	}
	
	private void closeSession(){
		AppContext.get().closeSession();
	}
	public int save(T object){
		Transaction transaction;

		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			transaction.begin();
			Serializable objectId = session.save(object);
			transaction.commit();
			session.flush();
			return (int) objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}finally {
			if (session.isOpen()){
                session.close();
            }
			//closeSession();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Object find(T object, Serializable id){
		try{
			Session session = getSession();
			T objectId = (T) session.load(object.getClass(), id);
			session.flush();
			return objectId;
		}catch (Exception e) {
			System.out.println("Exception while company find"+e);
			throw e;
		}/*finally{
			closeSession();
		}*/
	}
	
	public boolean update(T object){
		Transaction transaction;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			transaction.begin();
			session.update(object);;
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.out.println("Exception while update company"+e);
			return false;
		}finally{
			session.flush();
			closeSession();
		}
	}
}
