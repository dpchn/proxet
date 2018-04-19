package com.proxet.api.service;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.DeviceDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Company;
import com.proxet.api.model.Devices;
import com.proxet.core.context.AppContext;

@Service
public class DeviceService {

	
	public int AddDevices(String deviceId, int companyId) {
		DeviceDao dao = AppContext.get().getDAO(DeviceDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		Devices devices;
		devices = new Devices(deviceId, Status.ACTIVE);
		devices.setCompany(company);
		int id = dao.save(devices);
		System.out.println("Device id :" + id);
		return id;
	}
	
}
