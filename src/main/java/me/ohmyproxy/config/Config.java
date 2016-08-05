package me.ohmyproxy.config;

import java.io.*;
import java.util.Properties;


public class Config {

    private Properties properties;

    private Config(String filepath) throws Exception {
        loadPropertiesFromFile(filepath);
    }

    private Config() {

    }

    private void loadPropertiesFromFile(String filepath) throws Exception {
        properties = new Properties();
        InputStream input = null;

        input = new FileInputStream(filepath);
        properties.load(input);

        if (input != null) {
            input.close();
        }

    }

    public static Config loadConfiguration(String filepath) throws Exception {
        Config cfg = new Config(filepath);
        return cfg;
    }

    public String getFindProxiesEndpoint() {
        return properties.getProperty("ohmyproxy.endpoint") + "/findProxies";
    }

    public static Config loadConfigurationWithEndpoint(String endpoint) {
        Config cfg = new Config();
        cfg.initializePropertiesWithEndpoint(endpoint);
        return cfg;
    }

    private void initializePropertiesWithEndpoint(String endpoint) {
        properties = new Properties();
        properties.setProperty("ohmyproxy.endpoint", endpoint);
    }
}
