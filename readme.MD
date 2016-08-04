# OhMyProxy-client

OhMyProxy-client is a library that provides free proxies

The operation of this library is by connecting via GET requests to the server , which contains different proxies, and will be updated every few minutes .

Perfect for:
  - Web scraping
  - Anonymous navigation
  - Check your services healthy from another site

### Configuration

Modify the application.properties file with the endpoint needed. Default value is correct anyway

### Usage

```sh
OhMyProxyClient client = OhMyProxyClient.getInstance();
Proxy proxy = client.getRandomProxy();
java.net.Proxy proxyJavaNet = proxy.getJavaNetProxy();
```

### Todos

 - Filter by country
 - More proxies!!!