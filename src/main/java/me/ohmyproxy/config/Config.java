package me.ohmyproxy.config;

import java.util.Properties;


public class Config {

    private Properties properties;

    private Config() {

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
