package com.proxet.api.model;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.proxet.api.framework.Status;

@Entity
@Table(name="devices", catalog="proxet")
public class Devices {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "compaign"))
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",unique=true, nullable=false)
	private int id;

	@Column(name="DEVICE_UI_ID")
	private String deviceUId;

	@Column(name="LOCATION")
	private String location;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	/*@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=CompaignRule.class)
	private Set<CompaignRule> compaignRule = new HashSet<>();
*/
	public Devices() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Devices( String deviceId,String location, Status status) {
		super();
		this.deviceUId = deviceId;
		this.location = location;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDeviceUId() {
		return deviceUId;
	}
	public void setDeviceUId(String deviceId) {
		this.deviceUId = deviceId;
	}
	
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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


	/*public Set<CompaignRule> getCompaignRule() {
		return compaignRule;
	}


	public void setCompaignRule(Set<CompaignRule> compaignRule) {
		this.compaignRule = compaignRule;
	}*/
	
	
	
	

}
