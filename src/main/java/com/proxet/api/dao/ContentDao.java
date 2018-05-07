package com.proxet.api.dao;

import com.proxet.api.model.Content;

public class ContentDao extends DAO<Content>{

	public int saveContent(Content content){
		return super.save(content);
	}
}
