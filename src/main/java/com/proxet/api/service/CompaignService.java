package com.proxet.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompaignDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Compaign;
import com.proxet.api.model.Company;
import com.proxet.api.util.ConstantPattern;
import com.proxet.core.context.AppContext;

@Service
public class CompaignService {

	Compaign compaign;

	public List<Map<String, Object>> addCompaign(HttpServletRequest request, String title, String startDate, String endDate, String startTime,
			String endTime, int companyId) {
		CompaignDao compaignDao = AppContext.get().getDAO(CompaignDao.class);
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
		
		return getCompaignList(companyId);
	}
	
	public List<Map<String, Object>>getCompaignList(int companyId){
		List<Map<String, Object>> list=new ArrayList<>();
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = companyDao.find(new Company(), companyId);
		company.getCompaigns().stream().forEach(x->{
			Map<String,Object> map = new  HashMap<>();
			map.put("sn", list.size()+1);
			map.put("id", x.getId());
			map.put("title", x.getTitle().trim());
			map.put("startDate", x.getStartDate().toString());
			map.put("endDate", x.getEndDate().toString());
			map.put("status", x.getStatus().toString());
			list.add(map);
		});
		return list;
	}
	
	/*public static void main(String[] args) {
		CompaignService service =new CompaignService();
		System.out.println(service.getCompaignList(2).size());
	}*/
}
