package com.proxet.api.model;

import java.util.HashSet;
import java.util.Set;

import com.proxet.api.framework.Status;

public class AdCompaignRule {

	private int id;
	private AdCompaign compaign;
	private String ContentType;
	private Set<Devices> devices =  new HashSet<Devices>();
	
	public Set<Devices> getDevices() {
		return devices;
	}

	public void setDevices(Set<Devices> devices) {
		this.devices = devices;
	}

	private Status status;
	private String title;
	
	
	
	public AdCompaignRule() {
		// TODO Auto-generated constructor stub
	}
	
	public AdCompaignRule(AdCompaign compaign, String contentType,  Status status) {
		super();
		this.compaign = compaign;
		ContentType = contentType;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AdCompaign getCompaign() {
		return compaign;
	}
	public void setCompaign(AdCompaign compaign) {
		this.compaign = compaign;
	}
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Devices> getDevice() {
		return devices;
	}

	public void setDevice(Set<Devices> device) {
		this.devices = device;
	}
	
	
}
