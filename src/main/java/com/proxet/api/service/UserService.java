package com.proxet.api.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompaignRuleDao;
import com.proxet.api.dao.UserDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.CompaignRule;
import com.proxet.api.model.Content;
import com.proxet.api.model.User;
import com.proxet.api.util.ConstantPattern;
import com.proxet.api.util.ImageFileAndSave;
import com.proxet.core.context.AppContext;

@Service
public class UserService {

	private static final Map<String, String> contactNoWithDevice = new ConcurrentHashMap<>();

	@SuppressWarnings("unchecked")
	public User createUser(String fName, String lName, String email, String contactNo) {
		UserDao dao = AppContext.get().getDAO(UserDao.class);
		User user = new User(fName, lName, email, contactNo, Status.ACTIVE.toString());
		int id = dao.save(user);
		if (id > 0)
			return user;
		return null;
	}

	public User loginUser(String contactNo) {
		UserDao dao = AppContext.get().getDAO(UserDao.class);
		User user = dao.findByContactNo(contactNo);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getMappedAdvertisement(String deviceId, String contactNo,
			HttpServletRequest request) {
		CompaignRuleDao ruleDao = AppContext.get().getDAO(CompaignRuleDao.class);
		DeviceService deviceService = new DeviceService();
		List<Integer> listOfRulesId = deviceService.getMappedAdvertisementToDevice(deviceId);
		List<Map<String, Object>> listOfComaignRules = new ArrayList<>();
		ImageFileAndSave image = new ImageFileAndSave();
		for (Integer id : listOfRulesId) {
			CompaignRule rule = new CompaignRule();
			rule = (CompaignRule) ruleDao.find(rule, id);
			Date endDateTime = rule.getEndTime();
			Date currentDateTime = new Date();
			try {
				currentDateTime = ConstantPattern.sdf.parse(ConstantPattern.sdf.format(currentDateTime));
				if (endDateTime.after(currentDateTime)) {
					Content content = rule.getContent();
					Map<String, Object> object = new HashedMap();
					object.put("shortNotification", content.getShortNotification());
					object.put("longNotification", content.getLongNotification());
					object.put("title", content.getName());
					object.put("file", image.getBaseURL(request) + content.getFilePath());
					listOfComaignRules.add(object);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return listOfComaignRules;
	}

	public boolean isContactMappedWithDevice(String deviceId, String contactNo) {
		String phone = contactNoWithDevice.get(deviceId);
		if (phone == null) {
			contactNoWithDevice.put(deviceId, contactNo);
			return false;
		}
		return true;
	}

	public boolean isUserExist(String contactNo) {
		UserDao dao = AppContext.get().getDAO(UserDao.class);
		User user = dao.findByContactNo(contactNo);
		if (user == null)
			return false;
		return true;
	}

	/*
	 * public static void main(String[] args) throws ParseException {
	 * CompaignRuleDao ruleDao = AppContext.get().getDAO(CompaignRuleDao.class);
	 * DeviceService deviceService = new DeviceService(); List<Integer>
	 * listOfRulesId = deviceService.getMappedAdvertisementToDevice("CS");
	 * CompaignRule rule = new CompaignRule(); rule = (CompaignRule)
	 * ruleDao.find(rule, 8); Date date = rule.getStartTime();
	 * System.out.println("Time " + rule.getStartTime()); Date d = new Date();
	 * Date a = ConstantPattern.sdf.parse(ConstantPattern.sdf.format(d));
	 * System.out.println(a.after(date)); // rule =
	 * (CompaignRule)ruleDao.find(rule, 8); //
	 * System.out.println(rule.getContent().getLongNotification()); //
	 * ruleDao.getCompaignRuleByCompaignId(8).getCompaign().getCompaignRule().
	 * getContent(); // System.out.println(new
	 * UserService().getMappedAdvertisement("CS", // request)); }
	 */
}
