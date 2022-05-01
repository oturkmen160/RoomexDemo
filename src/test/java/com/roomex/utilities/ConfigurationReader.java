package com.roomex.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            //which file to read
            String path = "Configuration.properties";
            //read the file into java using above path
            FileInputStream input = new FileInputStream(path);
            // create Properties object
            properties = new Properties();
            //the values fed into Properties object in key/value format
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        //use getProperty method to return String value
        return properties.getProperty(keyName);
    }

}
