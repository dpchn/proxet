package com.proxet.api.service;

import java.io.Serializable;
import java.util.HashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.proxet.api.model.CompanyEnrollment;
import com.proxet.api.model.CompanyLogin;
import com.proxet.core.context.AppContext;
import com.proxet.dao.CompanyDao;


/**
 * 
 * @author dpchn
 *24/03/2018
 */
@Service
public class CompanyService {

	CompanyEnrollment companyEnrollment;
	CompanyLogin companyLogin;
	
	/**
	 * Enroll company and there is one-to-one mapping with login table
	 */
	public HashMap<String, String> saveEnroll(String firstName, String lastName, String email, String password, String company) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);

		companyEnrollment = new CompanyEnrollment(firstName, lastName, company);
		companyLogin = new CompanyLogin(email, password);
		companyEnrollment.setCompanyLogin(companyLogin);
		companyLogin.setCompanyEnrollment(companyEnrollment);
		HashMap<String, String> data = new HashMap<>();
		
		if(dao.save(companyEnrollment)>0){
			data.put("company", companyEnrollment.getCompany());
			data.put("email", companyEnrollment.getCompanyLogin().getEmail());
			return data;
		}
		return null;
	}

	public CompanyLogin login(String email, String password){
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		companyLogin = new CompanyLogin(email, password);
		return dao.login(email, password);
		
	}
}
