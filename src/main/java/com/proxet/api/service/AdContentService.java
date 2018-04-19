package com.proxet.api.service;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.AdContentDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.AdContent;
import com.proxet.api.model.Company;
import com.proxet.core.context.AppContext;

@Service
public class AdContentService {

	
	public int addContent(String contentType, String shortNotification, String longNotification, int companyId) {
		AdContentDao contentDao = AppContext.get().getDAO(AdContentDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		AdContent content ;
		Company company = new Company();
		company = companyDao.find(company, companyId);
		content = new AdContent(company, contentType, shortNotification, longNotification, Status.ACTIVE);
		contentDao.saveContent(content);
		return 0;
	}
}
