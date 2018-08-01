package com.proxet.api.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.User;
import com.proxet.core.context.AppContext;

public class UserDao extends DAO{

	public User findByContactNo(String contactNo){
	
		Session session = AppContext.get().openSession();
		String sql = "from User where CONTACT_NO=:contact";
		Query query = session.createQuery(sql);
		query.setParameter("contact", contactNo);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	
	public static void main(String[] args) {
		User user = new UserDao().findByContactNo("7897894561");
		if(user!=null){
			System.out.println(user.getContactNo());
		}
	}
}
