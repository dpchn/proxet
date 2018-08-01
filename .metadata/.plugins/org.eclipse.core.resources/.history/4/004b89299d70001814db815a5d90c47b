package com.proxet.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.proxet.api.model.Content;
import com.proxet.core.context.AppContext;

public class ContentDao extends DAO<Content>{

	public int saveContent(Content content){
		return super.save(content);
	}
	
	
	public List<Integer> getContentIdList(int id){
		Session session = AppContext.get().openSession();
		String sql = "Select ID from ad_content where COMPANY_ID=:id";
		Query query = session.createSQLQuery(sql);
		query.setParameter("id", id);
		return query.list();
	}
	
	/*public static void main(String[] args) {
		System.out.println(new ContentDao().getContentId(2).size());
	}*/
}
