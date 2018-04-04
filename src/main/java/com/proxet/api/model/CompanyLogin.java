package com.proxet.api.model;

import com.proxet.api.framework.Status;

public class CompanyLogin {

	private int companyId;
	private int id;
	private String email;
	private String password;
	private Company companyEnrollment;
	private Status status;
	private Company company;
	
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public CompanyLogin(){
		
	}
	public CompanyLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	
	public Company getCompanyEnrollment() {
		return companyEnrollment;
	}


	public void setCompanyEnrollment(Company companyEnrollment) {
		this.companyEnrollment = companyEnrollment;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
