package org.softserve.edu.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Generator {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());
    public static String randomString;

    public static String randomString(){

        randomString = RandomStringUtils.randomAlphabetic(10);
        LOG.info(randomString);

        return randomString;
    }

    public static String randomString(int charNum){

        randomString = RandomStringUtils.randomAlphabetic(charNum);
        LOG.info(randomString);

        return randomString;
    }

    public static String randomNumericString(int charNum){

        randomString = RandomStringUtils.randomNumeric(charNum);
        LOG.info(randomString);

        return randomString;
    }
}
