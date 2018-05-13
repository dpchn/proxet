package com.proxet.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.DeviceDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.CompaignRule;
import com.proxet.api.model.Company;
import com.proxet.api.model.Devices;
import com.proxet.core.context.AppContext;

@Service
public class DeviceService {

	Devices devices;
	
	/**
	 * Add Device Id
	 * @param deviceId
	 * @param location
	 * @param companyId
	 * @return
	 */
	public List<Map<String, Object>> AddDevices(String deviceId,String location, int companyId) {
		DeviceDao dao = AppContext.get().getDAO(DeviceDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		devices = new Devices(deviceId, location, Status.ACTIVE);
		devices.setCompany(company);
		int id = dao.save(devices);
		if(id>0)
			return mapDevicesInList(companyId);
		else 
			return null;
	}
	
	/**
	 * Get Devices List
	 * @param companyId
	 * @return
	 */
	public List<Map<String, Object>> getDeviceList(int companyId){
		return mapDevicesInList(companyId);
	}
	
	
	/**
	 * Get Device List
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> mapDevicesInList(int companyId){
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		List<Devices> list = company.getDevices();
		List<Map<String, Object>> deviceList = new ArrayList<>();
		int count =1;
		list.stream().forEach(x->{
								Map<String, Object> map = new HashedMap();
								map.put("sn", deviceList.size()+1);
								map.put("deviceId", x.getDeviceUId());
								map.put("location", x.getLocation());
								map.put("status", x.getStatus());
								deviceList.add(map);
							});
		return deviceList;
	}
	
	
	public List<Integer> getMappedAdvertisementToDevice(String deviceId){
		DeviceDao dao = AppContext.get().getDAO(DeviceDao.class);
		int id = dao.getDeviceByDeviceUId(deviceId).getId();
		List<Integer> list = dao.listOfRulesForAd(id);
		return list;
		
	}
	
	
	/*public static void main(String[] args) {
		new DeviceService().getMappedAdvertisementToDevice("CS");
	}*/
	/*public static void main(String[] args) {
		DeviceService service = new DeviceService();
		List<Map<String, Object>> list = service.mapDevicesInList(2);
		list.stream().forEach(x->System.out.println(x));
	}*/

}
