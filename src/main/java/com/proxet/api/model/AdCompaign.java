package com.proxet.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.proxet.api.framework.Status;

public class AdCompaign {

	private int id;
	private String title;
	private Date startDate;
	private Date EndDate;
	private Company company;
	private AdCompaignRule compaignRule;
	private Status status;

	private Set<AdCompaignRule> compaignRules = new HashSet<AdCompaignRule>(0);
	
	
	
	public AdCompaign() {
		// TODO Auto-generated constructor stub
	}
	
	public AdCompaign(String title, Date startDate, Date endDate, Company company) {
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
	

	public Set<AdCompaignRule> getCompaignRules() {
		return compaignRules;
	}

	public void setCompaignRules(Set<AdCompaignRule> compaignRules) {
		this.compaignRules = compaignRules;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public AdCompaignRule getCompaignRule() {
		return compaignRule;
	}

	public void setCompaignRule(AdCompaignRule compaignRule) {
		this.compaignRule = compaignRule;
	}
	
	
}
