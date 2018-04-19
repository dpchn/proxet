package com.proxet.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proxet.api.framework.Status;

/**
 * 
 * @author dpchn
 *
 */
/*@Entity
@Table(name="ad_compaign")*/
public class Compaign {

	//@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="ID")
	private int id;
	
	//@Column(name="TITLE")
	private String title;
	//@Column(name="START_DATE")
	private Date startDate;
//	@Column(name="END_DATE")
	private Date EndDate;
	private Company company;
	private CompaignRule compaignRule;
	//@Column(name="STATUS")
	private Status status;
	
	private static final long serialVersionUID = -723583058586873479L;
	private Set<CompaignRule> compaignRules = new HashSet<CompaignRule>(0);
	
	
	
	public Compaign() {
		// TODO Auto-generated constructor stub
	}
	
	public Compaign(String title, Date startDate, Date endDate, Company company) {
		super();
		this.title = title;
		this.startDate = startDate;
		EndDate = endDate;
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	

	public Set<CompaignRule> getCompaignRules() {
		return compaignRules;
	}

	public void setCompaignRules(Set<CompaignRule> compaignRules) {
		this.compaignRules = compaignRules;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CompaignRule getCompaignRule() {
		return compaignRule;
	}

	public void setCompaignRule(CompaignRule compaignRule) {
		this.compaignRule = compaignRule;
	}
	
	
}
