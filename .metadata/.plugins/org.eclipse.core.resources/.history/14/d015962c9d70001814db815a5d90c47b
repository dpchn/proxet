package com.proxet.api.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompanyDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Compaign;
import com.proxet.api.model.CompaignRule;
import com.proxet.api.model.Company;
import com.proxet.api.model.CompanyLogin;
import com.proxet.api.model.Content;
import com.proxet.api.model.Devices;
import com.proxet.api.validator.Encryption;
import com.proxet.core.context.AppContext;

/**
 * 
 * @author dpchn 24/03/2018
 */
@Service
public class CompanyService {

	CompanyLogin companyLogin;
	Devices devices;
	Content content;
	Compaign compaign;
	CompaignRule compaignRule;

	/**
	 * Enroll company and there is one-to-one mapping with login table
	 */
	// HttpServletRequest request;
	public int saveEnroll(String firstName, String lastName, String email, String password, String companyName,
			String phone) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		String hashPassword = Encryption.generateHash(password);
		Company company;
		company = new Company(firstName, lastName, companyName, phone, email);
		company.setStatus(Status.ACTIVE);
		companyLogin = new CompanyLogin(email, hashPassword);
		company.setCompanyLogin(companyLogin);
		companyLogin.setCompany(company);
		companyLogin.setStatus(Status.ACTIVE);
		HashMap<String, String> data = new HashMap<>();
		int id = dao.save(company);
		if (id > 0) {
			System.out.println("Id is :" + id);
			data.put("company", company.getCompanyName());
			data.put("email", company.getCompanyLogin().getEmail());
			data.put("phone", company.getPhone());
			return id;
		}
		return 0;
	}

	public CompanyLogin login(String email, String password, HttpServletRequest request) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		String hashPassword = Encryption.generateHash(password);
		companyLogin = new CompanyLogin(email, hashPassword);
		companyLogin = dao.login(email, hashPassword);
		request.getSession().setAttribute("id", companyLogin.getId());
		return companyLogin;
	}

	/*public static void main(String[] args) {
		String days[] = {"sun","mon"};
		String d [] = {"CS7y45","CS2","CS1"};
		new CompanyService().addCompaignRule("sdsf", "10:20", "10:20", d, days, 2, 1 );
	}*/
}
