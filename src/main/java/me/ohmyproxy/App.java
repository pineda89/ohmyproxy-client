package me.ohmyproxy;

/**
 * Created by dpineda-pc on 4/08/16.
 */
public class App {
    public static void main(String[] args) throws Exception {
        OhMyProxyClient client = OhMyProxyClient.getInstance();
        System.out.println(client.getAllProxies());

    }
}
