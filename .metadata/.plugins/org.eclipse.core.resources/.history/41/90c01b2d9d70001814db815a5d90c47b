package com.proxet.api.model;

import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.proxet.api.framework.Status;

/**
 * 
 * @author dpchn
 *
 */
@Entity
@Table(name="ad_compaign",catalog="proxet")
public class Compaign {


	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "compaignRule"))
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="TITLE", unique=false, nullable=false)
	private String title;

	@Column(name="START_DATE", unique=false, nullable=false)
	private Date startDate;

	@Column(name="END_DATE", nullable=false, unique=false)
	private Date EndDate;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL, targetEntity=CompaignRule.class)
	@JoinColumn(name="COMPAIGN_RULE")
	private CompaignRule compaignRule;
	
	@Column(name="STATUS", unique=false, nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	

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
