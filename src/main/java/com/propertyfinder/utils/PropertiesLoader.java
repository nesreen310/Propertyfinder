package com.propertyfinder.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private Properties properties;

    public PropertiesLoader(String path) {
        properties = new Properties();
        try {
            properties.load(PropertiesLoader.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String getHubURLSystemProperty() {
        return properties.getProperty("hubURL");
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    public String getChromeDriverPath() {
        return properties.getProperty("chromeDriver");
    }

    public String getInternetExplorerDriver_32Path() {
        return properties.getProperty("internetExplorerDriver_32");
    }

    public String getLogType() {
        return properties.getProperty("logType");
    }

    public long getImplicitlyWaitTimeout() {
        return Long.valueOf(properties.getProperty("implicitlyWaitTimeout"));
    }

    public String getLogin() {
        return properties.getProperty("login");
    }

    public String getPassWord() {
        return properties.getProperty("password");
    }
}
