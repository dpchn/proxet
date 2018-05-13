package com.proxet.api.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class ImageFileAndSave {

	public String saveImageFile(MultipartFile file){
		String SAVE_PATH_FILE = "webcontent\\images\\users";
		File fileSaveDir = new File(SAVE_PATH_FILE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        try {
        	
        	byte[] bytes = file.getBytes();
        	Date date = new Date();
        	Random random = new Random();
        	String fileName[] = file.getOriginalFilename().split("\\.");
        	fileName[0]=(date.getTime()+String.valueOf(random.nextInt(10	)));
        	
            Path path = Paths.get(SAVE_PATH_FILE +File.separator +fileName[0]+"."+fileName[1]);
            Files.write(path, bytes);
            return path.toString();
		} catch (Exception e) {
			System.out.println("Exception : "+e);
			e.printStackTrace();
		}
		return null;
	}
	
	public String fileRename(MultipartFile file){
		try {
			Date date = new Date();
        	Random random = new Random();
        	String fileName[] = file.getOriginalFilename().split("\\.");
        	fileName[0]=(date.getTime()+String.valueOf(random.nextInt(10)));
        	return fileName[0]+"."+fileName[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public String uploadImageCtlr(HttpServletRequest request, MultipartFile file){
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        File dir = new File(rootPath + File.separator + "img");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String latestName = fileRename(file);
        File serverFile = new File(dir.getAbsolutePath() + File.separator + latestName);
         
    //write uploaded image to disk
        try {
            try (InputStream is = file.getInputStream(); BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                int i;
                while ((i = is.read()) != -1) {
                    stream.write(i);
                }
                stream.flush();
            }
        } catch (IOException e) {
            System.out.println("error : " + e.getMessage());
        }
        return latestName;
    }  
    
    
	

	//get base URL
    public String getBaseURL(HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/img/";
    }
    
	
}
