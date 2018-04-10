package com.proxet.api.model;

import java.util.HashSet;
import java.util.Set;

import com.proxet.api.framework.Status;

public class Devices {
	private int id;
	private String deviceId;
	private Status status;
	private Company company;
	private Set<AdCompaignRule> compaignRule = new HashSet<>();

	public Devices() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Devices( String deviceId, Status status) {
		super();
		this.deviceId = deviceId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Set<AdCompaignRule> getCompaignRule() {
		return compaignRule;
	}


	public void setCompaignRule(Set<AdCompaignRule> compaignRule) {
		this.compaignRule = compaignRule;
	}
	
	
	
	

}
