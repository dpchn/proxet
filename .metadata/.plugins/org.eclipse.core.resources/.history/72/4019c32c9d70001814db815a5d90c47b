package com.proxet.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompaignDao;
import com.proxet.api.dao.CompaignRuleDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.ContentDao;
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
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public Map<String, Object> addCompaignRule(String title,String contentItem, String startTime, String endTime, String deviceId[], String scheduleDays[],
			String showContent,String frequency, int contentId, int companyId, int compaignid) {
		CompaignDao compaignDao = AppContext.get().getDAO(CompaignDao.class);
		CompaignRuleDao ruleDao =AppContext.get().getDAO(CompaignRuleDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		DeviceDao deviceDao = AppContext.get().getDAO(DeviceDao.class);
		ContentDao contentDao = AppContext.get().getDAO(ContentDao.class);
		List<Devices> devices = new ArrayList();
		Devices dev;
		Company company = new Company();
		Content content = new Content();
		compaign = compaignDao.find(new Compaign(), compaignid);
		company = companyDao.find(company, companyId);
		content = (Content) contentDao.find(content, contentId);
		Date et = null, st = null;
		Date endT=null,startT=null;
		try {
			for(int i=0; i<deviceId.length; i++){
				dev = new Devices();
				dev = deviceDao.getDeviceByDeviceUId(deviceId[i]);
				devices.add(dev);
			}
			st = ConstantPattern.stf.parse(startTime);
			et = ConstantPattern.stf.parse(endTime);
			Date compaignStartTime = compaign.getStartDate();
			Date compaignEndTime = compaign.getEndDate();
			compaignStartTime.setHours(st.getHours());
			compaignStartTime.setHours(st.getMinutes());
			compaignEndTime.setHours(et.getHours());
			compaignEndTime.setHours(et.getMinutes());
			startT = compaignStartTime;
			endT = compaignEndTime;
			
		} catch (Exception e) {
			System.out.println("Exception while date parsing " + e);
		}
		String days = Arrays.toString(scheduleDays);
		compaignRule = new CompaignRule(compaign, company, content, contentItem, days, startT, endT, devices,
				Status.ACTIVE, title,showContent, frequency);
		ruleDao.addCompaingRule(compaignRule);
		return getCompaignRule(compaignid);
	}
	
	
	public Map<String, Object> getCompaignRule(int compaignId){
		CompaignRuleDao ruleDao =AppContext.get().getDAO(CompaignRuleDao.class);
		compaignRule = ruleDao.getCompaignRuleByCompaignId(compaignId);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = new HashedMap();
		if(compaignRule==null)
			return null;
		map.put("id", compaignRule.getId());
		map.put("title", compaignRule.getTitle());
		map.put("contentType", compaignRule.getContentType());
		map.put("startDate", compaignRule.getStartTime());
		map.put("endDate", compaignRule.getEndTime());
		map.put("status", compaignRule.getStatus());
		map.put("device", compaignRule.getDevice());
		return map;
	}
	
/*	public static void main(String[] args) throws ParseException {
		ConstantPattern.stf.parse("10:30");
		SimpleDateFormat sdf = new SimpleDateFormat("D-M-yyyy HH:mm");
		System.out.println(ConstantPattern.stf.parse("20:30").getHours()+":"+ConstantPattern.stf.parse("20:30").getMinutes());
		System.out.println(ConstantPattern.sdf.parse("01-10-2015 10:30").getDay());
		//et = ConstantPattern.stf.parse(endTime);
		//new CompaignRuleService().getCompaignRule(1);
	}
*/
}
