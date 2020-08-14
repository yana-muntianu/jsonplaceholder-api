package org.softserve.edu.commons;

import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    static private Properties properties;

    private static void readProperties() {
        if (properties != null) {
            return;
        }

        properties = new Properties();

        try (InputStream stream = TestProperties.class.getResourceAsStream("/ui-config/config.properties")) {
            properties.load(stream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHomePageURL() {
        readProperties();
        return properties.getProperty("HOME_PAGE_URL");
    }

    public static int getWaiterTimeout() {
        readProperties();
        return Integer.valueOf(properties.getProperty("WAITERS_TIMEOUT"));
    }

}
