package me.ohmyproxy.domain;


import java.net.InetSocketAddress;

public class Proxy {
    private String ip;
    private int port;
    private String type;
    private String country;
    private long discoveryTime;
    private long lastCheckTime;
    private long rsTime;
    private String website;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(long lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public long getRsTime() {
        return rsTime;
    }

    public void setRsTime(long rsTime) {
        this.rsTime = rsTime;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getDiscoveryTime() {
        return discoveryTime;
    }

    public void setDiscoveryTime(long discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proxy proxy = (Proxy) o;

        if (port != proxy.port) return false;
        return ip != null ? ip.equals(proxy.ip) : proxy.ip == null;

    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", country='" + country + '\'' +
                ", discoveryTime=" + discoveryTime +
                ", lastCheckTime=" + lastCheckTime +
                ", rsTime=" + rsTime +
                ", website='" + website + '\'' +
                '}';
    }

    public java.net.Proxy getJavaNetProxy() {
        return new java.net.Proxy(getJavaNetProxyType(), new InetSocketAddress(ip, port));
    }

    private java.net.Proxy.Type getJavaNetProxyType() {
        return type.contains("SOCK") ? java.net.Proxy.Type.SOCKS : java.net.Proxy.Type.HTTP;
    }

}
