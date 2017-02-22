package com.niit.shoppingcart.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class Util 
	

{
    private static Logger logger=LoggerFactory.getLogger(Util.class);
    
    public static void upload(String path,MultipartFile file,String filename)
    {
        logger.debug("Method START:upload");
        logger.debug("path:" + path);
        logger.debug("filename:" + filename);
        
        if(!file.isEmpty())
        {
            try
            {
            byte[] bytes=file.getBytes();
            
            //Creating the directory to store file
            File dir=new File(path);
            if(!dir.exists())
            {
                dir.mkdirs();
            }
        //Create the file on server    
            File serverFile=new File(dir.getAbsolutePath()+File.separator+filename);
            BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            logger.info("Server File Location= " +serverFile.getAbsolutePath());
            }
            catch(Exception e)
            {
              e.printStackTrace();    
            }

    }
    
 }
}