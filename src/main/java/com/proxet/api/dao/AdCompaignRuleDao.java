package com.proxet.api.dao;

import com.proxet.api.model.CompaignRule;

public class AdCompaignRuleDao extends DAO<CompaignRule>{

	public int addCompaingRule(CompaignRule compaignRule){
		return super.save(compaignRule);
	}
}
