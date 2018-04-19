package com.proxet.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.AdCompaignDao;
import com.proxet.api.dao.AdCompaignRuleDao;
import com.proxet.api.dao.AdContentDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.DeviceDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.AdContent;
import com.proxet.api.model.Compaign;
import com.proxet.api.model.CompaignRule;
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

	CompanyLogin companyLogin;
	Devices devices;
	AdContent content;
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

	public CompanyLogin login(String email, String password, HttpServletRequest request) {
		CompanyDao dao = AppContext.get().getDAO(CompanyDao.class);
		String hashPassword = Encryption.generateHash(password);
		companyLogin = new CompanyLogin(email, hashPassword);
		companyLogin = dao.login(email, hashPassword);
		request.getSession().setAttribute("id", companyLogin.getId());
		return companyLogin;
	}

	public int AddDevices(String deviceId, int companyId) {
		DeviceDao dao = AppContext.get().getDAO(DeviceDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		devices = new Devices(deviceId, Status.ACTIVE);
		System.out.println(company.getFirstName());
		devices.setCompany(company);
		int id = dao.save(devices);
		System.out.println("Device id :" + id);
		return id;
	}

	public int addContent(String contentType, String shortNotification, String longNotification, int companyId) {
		AdContentDao contentDao = AppContext.get().getDAO(AdContentDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Set<AdContent> adContents = new HashSet<>();
		Company company = new Company();
		company = companyDao.find(company, companyId);
		content = new AdContent(company, contentType, shortNotification, longNotification, Status.ACTIVE);
		company.setAdContents(adContents);
		contentDao.saveContent(content);
		return 0;
	}

	public int addCompaign(HttpServletRequest request, String title, String startDate, String endDate, String startTime,
			String endTime, int companyId) {
		AdCompaignDao compaignDao = AppContext.get().getDAO(AdCompaignDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Date sd = null, ed = null;

		Company company = new Company();
		company = companyDao.find(company, companyId);
		try {
			sd = ConstantPattern.sdf.parse(startDate + " " + startTime);
			ed = ConstantPattern.sdf.parse(endDate + " " + endTime);

		} catch (Exception e) {
			System.out.println("Exception while date parsing " + e);
		}
		compaign = new Compaign(title, sd, ed, company);
		compaign.setStatus(Status.ACTIVE);
		request.getSession().setAttribute("compaignId", compaignDao.addCompaign(compaign));
		// compaignDao.addCompaign(compaign);
		return 0;
	}

	public int addCompaignRule(String title, String startTime, String endTime, String deviceId, String scheduleDays[],
			int companyId, int compaignid) {
		AdCompaignDao compaignDao = AppContext.get().getDAO(AdCompaignDao.class);
		AdCompaignRuleDao ruleDao =AppContext.get().getDAO(AdCompaignRuleDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		DeviceDao deviceDao = AppContext.get().getDAO(DeviceDao.class);
		Set<Devices> devices = new HashSet<>();
		Devices dev;
		int arr[] = new int[3];
		for(int i=1; i<3; i++){
			dev = new Devices();
			dev = (Devices) deviceDao.find(dev, i);
			devices.add(dev);
			System.out.println("Device id : "+dev.getDeviceId());
		}
		Company company = new Company();
		company = companyDao.find(company, companyId);
		Date et = null, st = null;
		try {
			st = ConstantPattern.stf.parse(startTime);
			et = ConstantPattern.stf.parse(endTime);

		} catch (Exception e) {
			System.out.println("Exception while date parsing " + e);
		}
		String days = scheduleDays.toString();
		System.out.println("Start Time "+ st);
		compaignRule = new CompaignRule(compaign, "img", company, days, st, et, devices,
				Status.ACTIVE, title);
		ruleDao.addCompaingRule(compaignRule);
		return 0;
	}
}
