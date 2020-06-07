package org.softserve.edu.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());
    private static File file;

    public File readJSONFile(String filePath) {
/*
Read JSON file using file path
 */
        try {
            file = new File(filePath);
            LOG.info("File Found : " + file.exists());

        }catch (Exception e){
            LOG.error(e);
            e.printStackTrace();
        }
        return file;
    }
/*
convert JSON file to string
 */
    private void convertToString(){

        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            LOG.info(content);

        }catch (IOException ioE){
            LOG.error(ioE);
            ioE.printStackTrace();
        }
    }

}
