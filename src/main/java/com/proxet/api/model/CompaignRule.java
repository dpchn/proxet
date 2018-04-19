package com.proxet.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.proxet.api.framework.Status;

public class CompaignRule {

	private int id;
	private Compaign compaign;
	private String ContentType;
	private Company company;
	private String scheduleDays;
	private Date startTime;
	private Date endTime;
	private Set<Devices> devices =  new HashSet<Devices>();
	


	
	public CompaignRule(Compaign compaign, String contentType, Company company, String scheduleDays, Date startTime,
			Date endTime, Set<Devices> devices, Status status, String title) {
		super();
		this.compaign = compaign;
		ContentType = contentType;
		this.company = company;
		this.scheduleDays = scheduleDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.devices = devices;
		this.status = status;
		this.title = title;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(String days) {
		this.scheduleDays = days;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Devices> getDevices() {
		return devices;
	}

	public void setDevices(Set<Devices> devices) {
		this.devices = devices;
	}

	private Status status;
	private String title;
	
	
	
	public CompaignRule() {
		// TODO Auto-generated constructor stub
	}
	
	public CompaignRule(Compaign compaign, String contentType,  Status status) {
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
	public Compaign getCompaign() {
		return compaign;
	}
	public void setCompaign(Compaign compaign) {
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
