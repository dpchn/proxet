package com.proxet.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import com.proxet.api.framework.Status;

@Entity
public class Company {

	private int id;
	private String firstName;
	private String lastName;
	private String companyName;
	private String phone;
	private CompanyLogin companyLogin;
	private Set<AdContent> adContents = new HashSet<AdContent>(0);
	private Set<AdCompaign> compaigns = new HashSet<AdCompaign>(0);
	private Set<Devices> devices = new HashSet<Devices>(0);
	private Status status;
	
	public Company(){
		
	}
	
	public Company( String firstName, String lastName, String company, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = company;
		this.phone = phone;
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
	
	public String getCompany() {
		return companyName;
	}
	public void setCompany(String companyName) {
		this.companyName = companyName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<AdContent> getAdContents() {
		return adContents;
	}

	public void setAdContents(Set<AdContent> adContents) {
		this.adContents = adContents;
	}

	public Set<AdCompaign> getCompaigns() {
		return compaigns;
	}

	public void setCompaigns(Set<AdCompaign> compaigns) {
		this.compaigns = compaigns;
	}

	public Set<Devices> getDevices() {
		return devices;
	}

	public void setDevices(Set<Devices> devices) {
		this.devices = devices;
	}
	
	
	
}
