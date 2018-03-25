package com.proxet.api.model;

public class CompanyLogin {

	private int id;
	private String email;
	private String password;
	private CompanyEnrollment companyEnrollment;

	
	public CompanyLogin(){
		
	}
	public CompanyLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	
	public CompanyEnrollment getCompanyEnrollment() {
		return companyEnrollment;
	}


	public void setCompanyEnrollment(CompanyEnrollment companyEnrollment) {
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

}
