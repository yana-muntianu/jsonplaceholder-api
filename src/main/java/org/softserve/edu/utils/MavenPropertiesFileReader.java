package org.softserve.edu.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MavenPropertiesFileReader {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());

    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("src/main/resources/maven.properties")) {

            Properties properties = new Properties();
/*
load property file from the resource
 */
            properties.load(inputStream);
/*
get certain property from the .properties file
 */
            String environment = properties.getProperty("UsedEnvironment");
            LOG.info("UsedEnvironment is " + environment);

        }catch (Exception e){
            LOG.error(e.getStackTrace());
        }
    }
}
