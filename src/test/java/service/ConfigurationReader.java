package service;

import java.util.ResourceBundle;

public class ConfigurationReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "dev"));

    public static String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
