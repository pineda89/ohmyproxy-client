# OhMyProxy-client

OhMyProxy-client is a library that provides free proxies

The operation of this library is by connecting via GET requests to the server , which contains different proxies, and will be updated every few minutes .

Perfect for:
  - Web scraping
  - Anonymous navigation
  - Check your services healthy from another site

### Import it!

```sh
<dependency>
  <groupId>com.github.pineda89</groupId>
  <artifactId>ohmyproxy-client</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

### Usage

```sh
OhMyProxyClient client = OhMyProxyClient.getInstance();
Proxy proxy = client.getRandomProxy();
java.net.Proxy proxyJavaNet = proxy.getJavaNetProxy();
```

### Todos

 - Filter by country
 - More proxies!!!