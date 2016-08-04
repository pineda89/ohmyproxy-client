package me.ohmyproxy.domain;

import java.util.ArrayList;
import java.util.List;


public class Response {
    private List<Proxy> proxyList = new ArrayList<Proxy>();

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public void setProxyList(List<Proxy> proxyList) {
        this.proxyList = proxyList;
    }
}
