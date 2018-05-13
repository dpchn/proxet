package com.proxet.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.proxet.api.framework.Status;

@Entity
@Table(name="ad_compaign_rule", catalog="proxet")
public class CompaignRule {


	//@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "compaign"))
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",unique=true, nullable=false)
	private int id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL,targetEntity=Compaign.class)
	@JoinColumn(name="COMPAIGN_ID")
	private Compaign compaign;
	
	@Column(name="CONTENT_TYPE")
	private String ContentType;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@Column(name="SCHEDULE_DAYS")
	private String scheduleDays;
	
	@Column(name="START_TIME")
	private Date startTime;
	
	@Column(name="END_TIME")
	private Date endTime;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="FREQUENCY")
	private String frequency;
	
	@Column(name="SHOW_CONTENT")
	private String showContent;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL,targetEntity=Content.class)
	@JoinColumn(name="CONTENT_ID")
	private Content content;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,targetEntity=Devices.class)
	@JoinTable(name = "device_compaign_rule_mmaping", catalog="proxet", joinColumns = { @JoinColumn(name = "COMPAIGN_RULE_ID", referencedColumnName="ID") }, inverseJoinColumns = { @JoinColumn(name = "DEVICE_ID", referencedColumnName="ID") })
	private List<Devices> devices =  new ArrayList<Devices>();
	
	public CompaignRule(Compaign compaign, Company company,Content content,String contentType, String scheduleDays, Date startTime,
			Date endTime, List<Devices> devices, Status status, String title, String showContent, String frequency) {
		super();
		this.compaign = compaign;
		this.ContentType = contentType;
		this.company = company;
		this.content = content;
		this.scheduleDays = scheduleDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.devices = devices;
		this.status = status;
		this.title = title;
		this.frequency = frequency;
		this.showContent = showContent;
	}

	public CompaignRule() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getShowContent() {
		return showContent;
	}

	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}

	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
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
	
	
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
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

	public List<Devices> getDevice() {
		return devices;
	}

	public void setDevice(List<Devices> device) {
		this.devices = device;
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

}
