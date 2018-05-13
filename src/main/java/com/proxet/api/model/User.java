package com.proxet.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user",catalog="proxet")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID",unique=true,nullable=false)
	int id;
	
	@Column(name="FIRST_NAME",nullable=true)
	String fName ;
	@Column(name="LAST_NAME", nullable=true)
	String lName;
	@Column(name="EMAIL", nullable=true)
	String email;
	@Column(name="CONTACT_NO", nullable=false,length=12)
	String contactNo;
	@Column(name="STATUS", nullable=false)
	String status;
	
	public User(){
		
	}
	
	
	
	public User(String fName, String lName, String email, String contactNo, String status) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.contactNo = contactNo;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
