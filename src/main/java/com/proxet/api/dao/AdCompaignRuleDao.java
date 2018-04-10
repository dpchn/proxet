package com.proxet.api.dao;

import com.proxet.api.model.AdCompaignRule;

public class AdCompaignRuleDao extends DAO<AdCompaignRule>{

	public int addCompaingRule(AdCompaignRule compaignRule){
		return super.save(compaignRule);
	}
}
