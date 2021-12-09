package com.dalhousie.bloodDonation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentalProperties {
    private static final Properties properties = new Properties();

    public static Properties getProperties(String filename) {
        try (InputStream input = EnvironmentalProperties.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
