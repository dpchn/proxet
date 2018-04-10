package com.proxet.api.dao;

import com.proxet.api.model.AdCompaign;

public class AdCompaignDao extends DAO<AdCompaign>{

	public int addCompaign(AdCompaign compaign){
		return super.save(compaign);
	}
}
