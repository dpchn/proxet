package com.proxet.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.Devices;
import com.proxet.core.context.AppContext;

public class DeviceDao extends DAO<Devices> {

	public int save(Devices devices) {
		int companyId = super.save(devices);
		return companyId;
	}
	
	public List<Devices> getDeviceList(int id){
		Session session = AppContext.get().openSession();
		String sql = "from Devices where COMPANY_ID=:id";
		Query query =  session.createQuery(sql);
		query.setParameter("id", id);
		return query.list();

	}
	
	public Devices getDeviceByDeviceUId(String deviceUid){
		Session session = AppContext.get().openSession();
		String sql = "from Devices where DEVICE_UI_ID=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, deviceUid);
		
		Devices devices = (Devices) query.uniqueResult();
		return devices;
	}
/*	public static void main(String[] args) {
		String str[] = {"CS","CS7y45"};
		List<String> list = new ArrayList<String>();
		list.add("CS");
		list.add("CS7y45");
		new DeviceDao().getDeviceByDeviceUId("CS7y45");
	}*/
}
