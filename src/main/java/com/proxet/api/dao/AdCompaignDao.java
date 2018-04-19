package com.proxet.api.dao;

import com.proxet.api.model.Compaign;

public class AdCompaignDao extends DAO<Compaign>{

	public int addCompaign(Compaign compaign){
		System.out.println(compaign.getTitle()+" "+compaign.getEndDate());
		return super.save(compaign);
	}
}
