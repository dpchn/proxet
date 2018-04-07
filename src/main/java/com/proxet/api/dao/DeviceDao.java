package com.proxet.api.dao;

import org.hibernate.Session;

import com.proxet.api.model.Company;
import com.proxet.api.model.Devices;

public class DeviceDao extends DAO<Devices> {

	public int save(Devices devices) {
		int companyId = super.save(devices);
		return companyId;
	}
	
	public Company find(Company object,int id){
		try{
			Session session = getSession();
			Company objectId = (Company) session.load(object.getClass(), id);
			session.flush();
			System.out.println("Oject id is : "+objectId.getId()+"  "+object.getClass());
			return objectId;
		}catch (Exception e) {
			System.out.println("Exception while renoll company"+e);
			throw e;
		}
	}
}
