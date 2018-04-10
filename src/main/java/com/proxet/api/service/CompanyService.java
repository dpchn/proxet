package com.proxet.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.AdCompaignDao;
import com.proxet.api.dao.AdContentDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.DeviceDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.AdCompaign;
import com.proxet.api.model.AdCompaignRule;
import com.proxet.api.model.AdContent;
import com.proxet.api.model.Company;
import com.proxet.api.model.CompanyLogin;
import com.proxet.api.model.Devices;
import com.proxet.api.util.ConstantPattern;
import com.proxet.api.validator.Encryption;
import com.proxet.core.context.AppContext;

/**
 * 
 * @author dpchn 24/03/2018
 */
@Service
public class CompanyService {

	Company company;
	CompanyLogin companyLogin;
	Devices devices;
	AdContent content;
	AdCompaign compaign;
	AdCompaignRule compaignRule;

	/**
	 * Enroll company and there is one-to-one mapping with login table
	 */
	// HttpServletRequest request;
	public int saveEnroll(String firstName, String lastName, String email, String password, String companyName,
			String phone) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);

			System.out.println(firstName+" "+lastName+" "+email+" "+password+" "+companyName+" "+phone);
		String hashPassword = Encryption.generateHash(password);
		company = new Company(firstName, lastName, companyName, phone);
		company.setStatus(Status.ACTIVE);
		companyLogin = new CompanyLogin(email, hashPassword);
		company.setCompanyLogin(companyLogin);
		companyLogin.setCompanyEnrollment(company);
		companyLogin.setStatus(Status.ACTIVE);
		HashMap<String, String> data = new HashMap<>();
		int id = dao.save(company);
		if (id > 0) {
			System.out.println("Id is :" + id);
			data.put("company", company.getCompany());
			data.put("email", company.getCompanyLogin().getEmail());
			data.put("phone", company.getPhone());
			return id;
		}
		return 0;
	}

	public CompanyLogin login(String email, String password) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		String hashPassword = Encryption.generateHash(password);
		companyLogin = new CompanyLogin(email, hashPassword);
		return dao.login(email, password);
	}

	public int AddDevices(String deviceId, int companyId) {
		DeviceDao dao = AppContext.get().getDAO(DeviceDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Set<Devices> device = new HashSet<>();
		System.out.println("Id .... " + companyId);
		devices = new Devices(deviceId, Status.ACTIVE);
		company = companyDao.find(company, companyId);
		devices.setCompany(company);
		//company.setDevices(device);
		int id = dao.save(devices);
		//companyDao.update(company);
		System.out.println("Device id :" + id);
		return id;
	}

	public int addContent(String contentType, String shortNotification, String longNotification, int companyId) {
		AdContentDao contentDao = AppContext.get().getDAO(AdContentDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Set<AdContent> adContents = new HashSet<>();
		company = companyDao.find(company, companyId);
		content = new AdContent(company, contentType, shortNotification, longNotification, Status.ACTIVE);
		company.setAdContents(adContents);
		contentDao.saveContent(content);
		return 0;
	}
	public int addCompaign(String title, String startDate, String endDate, String startTime, String endTime, int companyId) {
		AdCompaignDao compaignDao = AppContext.get().getDAO(AdCompaignDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Set<AdCompaign> compaigns = new HashSet<>();
		company = companyDao.find(company, companyId);
		Date sd=null, ed=null;
		try{
			sd = ConstantPattern.sdf.parse(startDate+" "+startTime);
			ed = ConstantPattern.sdf.parse(endDate+" "+endTime);
		}catch (Exception e) {
			System.out.println("Exception while date parsing "+e);
		}
		compaign.setStartDate(sd);
		compaign.setEndDate(ed);
		compaign.setCompany(company);
		compaign.setTitle(title);
		company.setCompaigns(compaigns);
		compaignDao.addCompaign(compaign);
	//	company.setAdContents(adContents);
		return 0;
	}
}
