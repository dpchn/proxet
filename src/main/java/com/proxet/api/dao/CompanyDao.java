package com.proxet.api.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.Company;
import com.proxet.api.model.CompanyLogin;
import com.proxet.core.context.AppContext;

public class CompanyDao extends DAO<Company> {

	public int save(Company company) {
		int companyId = super.save(company);
		return companyId;
	}

	
	public boolean update(Company company){
		return super.update(company);
	}
	
	/*public int loginSave(CompanyLogin company) {
		Transaction transaction;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			transaction.begin();
			Serializable objectId = session.save(company);
			transaction.commit();
			session.flush();
		//	session.close();
			return (int) objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}*/
	
	public CompanyLogin login(String email, String password) {
		Session session = AppContext.get().openSession();
		CompanyLogin user = null;
		Query query = session
				.createQuery("from com.proxet.api.model.CompanyLogin where EMAIL=:email and PASSWORD =:password");

		query.setParameter("email", email);
		query.setParameter("password", password);
		user = (CompanyLogin) query.uniqueResult();
		return user;
	}
	
	
	public Company find(Company company, int id){
		return (Company) super.find(company, id);
	}
}
