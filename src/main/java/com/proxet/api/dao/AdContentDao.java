package com.proxet.api.dao;

import com.proxet.api.model.AdContent;

public class AdContentDao extends DAO<AdContent>{

	public int saveContent(AdContent content){
		return super.save(content);
	}
}
