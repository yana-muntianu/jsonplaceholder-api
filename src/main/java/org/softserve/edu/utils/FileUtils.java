package org.softserve.edu.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;

public class FileUtils {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());
    public String content;

    public String readFile(String fileName) {

        try {
            File file = new File(
                    FileUtils.class.getClassLoader().getResource(fileName).getFile()
            );

            //File is found
            LOG.info("File Found : " + file.exists());

            //Read File Content
            content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);

        }catch (Exception e){
            LOG.error(e.getStackTrace());
        }
        return content;
    }
    public static void main (String[] args){
        String mvnFile = "maven.properties";
        FileUtils fileUtils = new FileUtils();
        fileUtils.readFile(mvnFile);
    }
}
