package com.proxet.api.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.CompaignRule;
import com.proxet.core.context.AppContext;

public class CompaignRuleDao extends DAO<CompaignRule>{

	public int addCompaingRule(CompaignRule compaignRule){
		return super.save(compaignRule);
	}
	
	
	public CompaignRule getCompaignRuleByCompaignId(int compaignId){
		Session session = AppContext.get().openSession();
		String sql = "from CompaignRule where COMPAIGN_ID=:id";
		Query query = session.createQuery(sql);
		query.setParameter("id", compaignId);
		CompaignRule rule =  (CompaignRule) query.uniqueResult();
		return rule;
	}
}
