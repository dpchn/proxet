package com.proxet.api.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.AdCompaignDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.model.Compaign;
import com.proxet.api.model.Company;
import com.proxet.api.util.ConstantPattern;
import com.proxet.core.context.AppContext;

@Service
public class AdCompaignService {

	public int addCompaign(String title, String startDate, String endDate, String startTime, String endTime, int companyId) {
		AdCompaignDao compaignDao = AppContext.get().getDAO(AdCompaignDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Compaign compaign = new Compaign();
		Date sd=null, ed=null;
		try{
			sd = ConstantPattern.sdf.parse(startDate+" "+startTime);
			ed = ConstantPattern.sdf.parse(endDate+" "+endTime);
		}catch (Exception e) {
			System.out.println("Exception while date parsing "+e);
		}
		Company company = new Company();
		compaign.setStartDate(sd);
		compaign.setEndDate(ed);
		compaign.setCompany(company);
		compaign.setTitle(title);
		compaignDao.addCompaign(compaign);
		return 0;
	}
}
