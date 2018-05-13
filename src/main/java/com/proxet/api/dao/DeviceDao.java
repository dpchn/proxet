package com.proxet.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.CompaignRule;
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
	
	
	public List<Integer> listOfRulesForAd(int deviceId){
		Session session = AppContext.get().openSession();
		String sql = "Select COMPAIGN_RULE_ID from device_compaign_rule_mmaping where DEVICE_ID=:id";
		Query query = session.createSQLQuery(sql);
		query.setParameter("id", deviceId);
		List<Integer> list = query.list();
		return list;
	}
	
	
	public static void main(String[] args) {
		//new DeviceDao().listOfRulesForAd(1);
		System.out.println(new DeviceDao().listOfRulesForAd(1).get(1));
	}
/*	public static void main(String[] args) {
		String str[] = {"CS","CS7y45"};
		List<String> list = new ArrayList<String>();
		list.add("CS");
		list.add("CS7y45");
		new DeviceDao().getDeviceByDeviceUId("CS7y45");
	}*/
}
