package com.proxet.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.proxet.api.dao.CompanyDao;
import com.proxet.api.dao.ContentDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Company;
import com.proxet.api.model.Content;
import com.proxet.api.util.ImageFileAndSave;
import com.proxet.core.context.AppContext;

@Service
public class ContentService {

	Content content;

	public List<Map<String, Object>> addContent(HttpServletRequest request, String filePath,String contentType, String name, String shortNotification, String longNotification,
			int companyId) {
		System.out.println("File path "+filePath);
		ContentDao contentDao = AppContext.get().getDAO(ContentDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		content = new Content(company, name, contentType, filePath, shortNotification, longNotification, Status.ACTIVE);
		contentDao.saveContent(content);
		return mapAllAdContents(request, company);
	}

	public List<Map<String, Object>> getAllAdContents(HttpServletRequest request, int companyId) {
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		return mapAllAdContents(request, company);
	}
	
	
	public List<Integer> getContentId(int companyId){
		ContentDao contentDao = AppContext.get().getDAO(ContentDao.class);
		return contentDao.getContentIdList(companyId);
	}

	public List<Map<String, Object>> mapAllAdContents(HttpServletRequest request, Company company){
		List<Content> contentList = company.getContents();
		List<Map<String, Object>> listOfContent = new ArrayList<>();
		contentList.stream().forEach(data -> {
			Map<String, Object> contentMap = new HashMap<String, Object>();
			contentMap.put("sn", listOfContent.size()+1);
			contentMap.put("name", data.getName());
			contentMap.put("notification", data.getShortNotification().trim());
			contentMap.put("conentType", data.getContentType());

			ImageFileAndSave image =  new ImageFileAndSave();
			contentMap.put("file", image.getBaseURL(request)+data.getFilePath());
			contentMap.put("createdOn", data.getCreatedOn().toString());
			listOfContent.add(contentMap);
		});
		return listOfContent;
	}
	
	/*public static void main(String[] args) {
		ContentService service = new ContentService();
		List<Object> list = service.addContent("aaaa", "","sjdfhs", "sfsdf", "asdsafd", 2);

		list.stream().forEach(x -> System.out.println(x));
	}*/
}
