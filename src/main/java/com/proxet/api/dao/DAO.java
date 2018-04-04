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
			
			session.flush();
			return (int) objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}
	
	
	/*public int find(T object, Serializable objectId2){
		try{
			Session session = getSession();
			CompanyEnrollment objectId = (CompanyEnrollment) session.load(object.getClass(), objectId2);;
			session.flush();
			System.out.println("Oject id is : "+objectId.getId()+" "+objectId2+" "+object.getClass());
			return objectId.getId();
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}*/
	
}
