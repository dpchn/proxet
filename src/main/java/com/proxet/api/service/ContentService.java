package com.proxet.api.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.proxet.api.dao.ContentDao;
import com.proxet.api.dao.CompanyDao;
import com.proxet.api.framework.Status;
import com.proxet.api.model.Company;
import com.proxet.api.model.Content;
import com.proxet.core.context.AppContext;

@Service
public class ContentService {

	Content content;

	public List<Map<String, Object>> addContent(String filePath,String contentType, String name, String shortNotification, String longNotification,
			int companyId) {
		ContentDao contentDao = AppContext.get().getDAO(ContentDao.class);
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		content = new Content(company, name, contentType, filePath, shortNotification, longNotification, Status.ACTIVE);
		contentDao.saveContent(content);
		return mapAllAdContents(company);
	}

	public List<Map<String, Object>> getAllAdContents(int companyId) {
		CompanyDao companyDao = AppContext.get().getDAO(CompanyDao.class);
		Company company = new Company();
		company = companyDao.find(company, companyId);
		return mapAllAdContents(company);
	}

	public List<Map<String, Object>> mapAllAdContents(Company company){
		List<Content> contentSet = company.getContents();
		// File file = new File(filePath, URLDecoder.decode(requestedFile,
		// "UTF-8"));
		List<Map<String, Object>> listOfContent = new ArrayList<>();
		contentSet.stream().forEach(data -> {
			Map<String, Object> contentMap = new HashMap<String, Object>();
			contentMap.put("name", data.getName());
			contentMap.put("notification", data.getShortNotification().trim());
			contentMap.put("conentType", data.getContentType());
			try {
				contentMap.put("file", getImageFromPath(data.getFilePath().trim()));
			} catch (Exception e) {
				e.printStackTrace();
			} 
			contentMap.put("createdOn", data.getCreatedOn().toString());
			listOfContent.add(contentMap);
		});
		return listOfContent;
	}

	public File getImageFromPath(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		// create FileInputStream which obtains input bytes from a file in a
		// file system
		// FileInputStream is meant for reading streams of raw bytes such as
		// image data. For reading streams of characters, consider using
		// FileReader.

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[2024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				// Writes to this byte array output stream
				bos.write(buf, 0, readNum);
				//System.out.println("read " + readNum + " bytes,");
			}
		} catch (IOException ex) {
			// Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

		byte[] bytes = bos.toByteArray();
		byte[] encodeBase64 = Base64.encodeBase64(bytes);
		String base64Encoded = new String(encodeBase64, "UTF-8");

		//System.out.println(base64Encoded);
		return file;
	}

	
	
	
	/*public static void main(String[] args) {
		ContentService service = new ContentService();
		List<Object> list = service.addContent("aaaa", "","sjdfhs", "sfsdf", "asdsafd", 2);

		list.stream().forEach(x -> System.out.println(x));
	}*/
}
