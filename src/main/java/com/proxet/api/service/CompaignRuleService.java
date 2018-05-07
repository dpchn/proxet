package com.proxet.api.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompaignDao;
import com.proxet.api.dao.CompaignRuleDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.DeviceDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Compaign;
import com.proxet.api.model.CompaignRule;
import com.proxet.api.model.Company;
import com.proxet.api.model.CompanyLogin;
import com.proxet.api.model.Content;
import com.proxet.api.model.Devices;
import com.proxet.api.util.ConstantPattern;
import com.proxet.core.context.AppContext;

@Service
public class CompaignRuleService {


	CompanyLogin companyLogin;
	Devices devices;
	Content content;
	Compaign compaign;
	CompaignRule compaignRule;
	
	public int addCompaignRule(String title,String content, String startTime, String endTime, String deviceId[], String scheduleDays[],
			String showContent,String frequency, int companyId, int compaignid) {
		CompaignDao compaignDao = AppContext.get().getDAO(CompaignDao.class);
		CompaignRuleDao ruleDao =AppContext.get().getDAO(CompaignRuleDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		DeviceDao deviceDao = AppContext.get().getDAO(DeviceDao.class);
		Set<Devices> devices = new HashSet<>();
		Devices dev;
		Company company = new Company();
		//deviceDao.getDeviceByDeviceUId(deviceId);
		compaign = compaignDao.find(new Compaign(), compaignid);
		company = companyDao.find(company, companyId);
		Date et = null, st = null;
		try {
			for(int i=0; i<deviceId.length; i++){
				dev = new Devices();
				dev = deviceDao.getDeviceByDeviceUId(deviceId[i]);
				devices.add(dev);
			}
			st = ConstantPattern.stf.parse(startTime);
			et = ConstantPattern.stf.parse(endTime);

		} catch (Exception e) {
			System.out.println("Exception while date parsing " + e);
		}
		String days = Arrays.toString(scheduleDays);
		compaignRule = new CompaignRule(compaign, content, company, days, st, et, devices,
				Status.ACTIVE, title,showContent, frequency);
		ruleDao.addCompaingRule(compaignRule);
		return 0;
	}
	
	
	public Map<String, Object> getCompaignRule(int compaignId){
		CompaignRuleDao ruleDao =AppContext.get().getDAO(CompaignRuleDao.class);
		compaignRule = ruleDao.getCompaignRuleByCompaignId(compaignId);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = new HashedMap();
		map.put("id", compaignRule.getId());
		map.put("title", compaignRule.getTitle());
		map.put("contentType", compaignRule.getContentType());
		map.put("startDate", compaignRule.getStartTime());
		map.put("endDate", compaignRule.getEndTime());
		map.put("status", compaignRule.getStatus());
		map.put("device", compaignRule.getDevice());
		return map;
	}
	
	public static void main(String[] args) {
		new CompaignRuleService().getCompaignRule(1);
	}

}
