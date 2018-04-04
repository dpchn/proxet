package com.proxet.api.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompanyDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Company;
import com.proxet.api.model.CompanyLogin;
import com.proxet.api.validator.Encryption;
import com.proxet.core.context.AppContext;


/**
 * 
 * @author dpchn
 *24/03/2018
 */
@Service
public class CompanyService {

	Company companyEnrollment;
	CompanyLogin companyLogin;
	
	/**
	 * Enroll company and there is one-to-one mapping with login table
	 */
	//HttpServletRequest request;
	public HashMap<String, String> saveEnroll(String firstName, String lastName, String email, String password, String company, String phone, HttpServletRequest request) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);

		String hashPassword= Encryption.generateHash(password);
		companyEnrollment = new Company(firstName, lastName, company, phone);
		companyEnrollment.setStatus(Status.ACTIVE);
		companyLogin = new CompanyLogin(email, hashPassword);
		companyEnrollment.setCompanyLogin(companyLogin);
		//companyLogin.setCompanyId(companyEnrollment.getId());
		companyLogin.setCompanyEnrollment(companyEnrollment);
		companyLogin.setCompanyEnrollment(companyEnrollment);
		companyLogin.setStatus(Status.ACTIVE);
		HashMap<String, String> data = new HashMap<>();
		int id =dao.save(companyEnrollment);
		request.setAttribute("id", id);
		if(id > 0){
			System.out.println("Id is :"+id);
			data.put("company", companyEnrollment.getCompany());
			data.put("email", companyEnrollment.getCompanyLogin().getEmail());
			data.put("phone",companyEnrollment.getPhone());
			return data;
		}
		return null;
	}

	public CompanyLogin login(String email, String password){
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		String hashPassword= Encryption.generateHash(password);
		companyLogin = new CompanyLogin(email, hashPassword);
		return dao.login(email, password);
	}
	
	
	public int AddDevices(String deviceId, HttpSession session, HttpServletRequest request){
		System.out.println("Session Id: "+session.getAttribute("id"));
		System.out.println("Request Id : "+request.getAttribute("id"));
		
		return 0;
		
	}
}
