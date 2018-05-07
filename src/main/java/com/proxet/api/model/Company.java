package com.proxet.api.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.proxet.api.framework.Status;

@Entity
@Table(name="company",catalog="proxet")
public class Company {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "devices"))
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_ID",unique=true, nullable=false)
	private int id;

	@Column(name="FIRSTNAME")
	private String firstName;

	@Column(name="LASTNAME")
	private String lastName;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="PHONE")
	private String phone;

	@Column(name="EMAIL")
	private String email;

	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private CompanyLogin companyLogin;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "company", cascade=CascadeType.ALL, targetEntity=Content.class)
	private List<Content> contents = new ArrayList<Content>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "company", cascade=CascadeType.ALL, targetEntity=Compaign.class)
	private List<Compaign> compaigns = new ArrayList<Compaign>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "company",cascade=CascadeType.ALL, targetEntity=Devices.class)
	private List<Devices> devices = new ArrayList<Devices>();
	
	
	public Company(){
		
	}
	
	public Company( String firstName, String lastName, String company, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = company;
		this.phone = phone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CompanyLogin getCompanyLogin() {
		return companyLogin;
	}


	public void setCompanyLogin(CompanyLogin companyLogin) {
		this.companyLogin = companyLogin;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	public List<Compaign> getCompaigns() {
		return compaigns;
	}

	public void setCompaigns(List<Compaign> compaigns) {
		this.compaigns = compaigns;
	}

	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
	
	
	
}
