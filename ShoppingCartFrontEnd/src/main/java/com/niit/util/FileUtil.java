package com.niit.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	//private static String workingDir = System.getProperty("user.dir");
	//E:\Software\Eclipse\eclipse-jee-neon-3-win32-x86_64\eclipse
	
	public static void upload(String path,MultipartFile file, String fileName)
	{
		System.out.println("Into upload Method");
		log.debug("Starting of the method upload");
		log.debug("Current Path :"+ Paths.get("").toFile());
		
		if(!file.isEmpty())
		{
			try {
				
				byte[] bytes = file.getBytes();
				
				// creating the directory to store file
				
				File dir = new File(path);
				if(!dir.exists())
					// make or create directory
					dir.mkdirs();
				
				// create file on server
				File serverFile = new File(dir.getAbsolutePath()
						+File.separator + fileName);
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				log.info("Server File Loactaion = "+ serverFile.getAbsolutePath());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		log.debug("Ending of the method Upload");
	}
	
	
	
	

}
