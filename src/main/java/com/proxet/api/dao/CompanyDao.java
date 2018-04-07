package com.proxet.api.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;

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
}
