package org.softserve.edu.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MavenPropertiesFileReader {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());

    public static String getMavenProperty(String propertyKey){

        try (InputStream inputStream = new FileInputStream("src/main/resources/maven.properties")) {

            Properties properties = new Properties();

//load property file from the resource

            properties.load(inputStream);

//get certain property from the .properties file

            String mavenProperty = properties.getProperty(propertyKey);
            LOG.info("UsedEnvironment is " + mavenProperty);
            return mavenProperty;

        }catch (Exception e){
            LOG.error(e.getStackTrace());
            return null;
        }
    }
}
