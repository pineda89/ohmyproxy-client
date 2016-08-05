package me.ohmyproxy;

import me.ohmyproxy.config.Config;
import me.ohmyproxy.connector.HttpConnector;
import me.ohmyproxy.connector.JsonParser;
import me.ohmyproxy.domain.Proxy;
import me.ohmyproxy.domain.Response;

import java.util.List;
import java.util.Random;

public class OhMyProxyClient {

    private static final String FILEPATH = "application.properties";

    private static OhMyProxyClient instance;

    private Config config;

    private OhMyProxyClient() throws Exception {
        loadConfiguration();
    }

    private OhMyProxyClient(String endpoint) {
        loadConfiguration(endpoint);
    }

    private void loadConfiguration(String endpoint) {
        config = Config.loadConfigurationWithEndpoint(endpoint);
    }

    private void loadConfiguration() throws Exception {
        config = Config.loadConfiguration(FILEPATH);
    }

    public synchronized static OhMyProxyClient getInstance() throws Exception {
        if (instance == null) {
            instance = new OhMyProxyClient();
        }
        return instance;
    }

    public synchronized static OhMyProxyClient getInstance(String endpoint) throws Exception {
        if (instance == null) {
            instance = new OhMyProxyClient(endpoint);
        }
        return instance;
    }


    private Response getProxiesFromWS() {
        String responseString = HttpConnector.sendGetRequestToEndpoint(config.getFindProxiesEndpoint());
        Response responseObject = JsonParser.parseStringToResponse(responseString);
        return responseObject;
    }

    public Proxy getRandomProxy() {
        Response response = getProxiesFromWS();
        Random random = new Random();
        return response.getProxyList().get(random.nextInt(response.getProxyList().size()));
    }

    public Proxy getLowerRsTimeProxy() {
        Response response = getProxiesFromWS();
        Proxy proxy = findLowerRsTimeProxyFromList(response.getProxyList());
        return proxy;
    }

    private Proxy findLowerRsTimeProxyFromList(List<Proxy> proxyList) {
        Proxy realProxy = null;
        for (Proxy proxy : proxyList) {
            if (realProxy == null) {
                realProxy = proxy;
            }
            else {
                if (proxy.getRsTime() < realProxy.getRsTime()) {
                    realProxy = proxy;
                }
            }
        }
        return realProxy;
    }

    public List<Proxy> getAllProxies() {
        Response response = getProxiesFromWS();
        return response.getProxyList();
    }

}
