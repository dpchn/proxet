package com.proxet.api.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.proxet.api.framework.Status;

@Entity
@Table(name="ad_content", catalog="proxet")
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	@Column(name="CONTENT_TYPE",unique=false, nullable=false)
	private String contentType;
	
	@Column(name="FILE_PATH",unique=false, nullable=false)
	private String filePath;
	
	@Column(name="NAME",unique=false, nullable=false)
	private String name;

	@Column(name="SHORT_NOTIFICATION", unique=false, nullable=false)
	private String shortNotification;

	@Column(name="LONG_NOTIFICATION", unique=false, nullable=false)
	private String longNotification;
	
	@Column(name="CREATED_AT",unique=true, nullable=false)
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="STATUS", unique=false, nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	
	public Content() {
		// TODO Auto-generated constructor stub
	}
	public Content(Company company,String name,String contentType, String filePath, String shortNotification, String longNotification,
			Status status) {
		super();
		this.filePath = filePath;
		this.company = company;
		this.contentType = contentType;
		this.name= name;
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
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
