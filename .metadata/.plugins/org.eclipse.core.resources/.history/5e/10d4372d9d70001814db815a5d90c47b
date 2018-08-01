package com.proxet.api.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.proxet.api.util.ConstantPattern;

public class CompanyEnrollmentForm {
	@NotEmpty(message="Enter First name")
	@Pattern(regexp = ConstantPattern.namePattern,message="Enter only alphbet")
	private String firstName;
	@NotEmpty(message="Enter last Name")
	@Pattern(regexp = ConstantPattern.namePattern,message ="Enter only alphbet")
	private String lastName;

	@NotEmpty(message="Enter email")
	@Email(message="Incorrect email")
	private String email;

	@NotEmpty(message="Enter password")
	private String password;
	@NotEmpty(message="Enter confirm password")
	private String confirmpassword;
	@NotEmpty(message="Enter company name")
	private String company;
	@NotEmpty(message="Enter password")
	@Pattern(regexp = ConstantPattern.phonePattern, message="Enter proper phone no.")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
