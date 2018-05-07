package com.proxet.api.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

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
	
}
