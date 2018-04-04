package com.proxet.api.model;

import com.proxet.api.framework.Status;

public class AdContent {

	private int id;
	private Company company;
	private String contentType;
	private String shortNotification;
	private String longNotification;
	private Status status;
	
	
	
	
	public AdContent() {
		// TODO Auto-generated constructor stub
	}
	public AdContent(Company company, String contentType, String shortNotification, String longNotification,
			Status status) {
		super();
		this.company = company;
		this.contentType = contentType;
		this.shortNotification = shortNotification;
		this.longNotification = longNotification;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getShortNotification() {
		return shortNotification;
	}
	public void setShortNotification(String shortNotification) {
		this.shortNotification = shortNotification;
	}
	public String getLongNotification() {
		return longNotification;
	}
	public void setLongNotification(String longNotification) {
		this.longNotification = longNotification;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
