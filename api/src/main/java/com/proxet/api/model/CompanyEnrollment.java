package com.proxet.api.model;

import javax.persistence.Entity;

@Entity
public class CompanyEnrollment {

	int id;
	String firstName;
	String lastName;
	String company;
	CompanyLogin companyLogin;
	
	public CompanyEnrollment(){
		
	}
	
	public CompanyEnrollment( String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
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
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
