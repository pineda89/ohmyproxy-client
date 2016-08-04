package me.ohmyproxy;

import me.ohmyproxy.connector.JsonParser;
import me.ohmyproxy.domain.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dpineda-pc on 4/08/16.
 */
public class JsonParserTest {

    private static final String VALID_JSON = "{\"proxyList\":[{\"ip\":\"63.150.152.151\",\"port\":8080,\"country\":null,\"discoveryTime\":1470297784959,\"lastCheckTime\":1470304379058,\"rsTime\":434,\"website\":\"hidemyass\"},{\"ip\":\"165.138.66.247\",\"port\":8080,\"country\":null,\"discoveryTime\":1470297791032,\"lastCheckTime\":1470304387142,\"rsTime\":3083,\"website\":\"hidemyass\"},{\"ip\":\"185.5.64.70\",\"port\":8080,\"country\":null,\"discoveryTime\":1470297805748,\"lastCheckTime\":1470303477672,\"rsTime\":203,\"website\":\"hidemyass\"},{\"ip\":\"88.157.149.250\",\"port\":8080,\"country\":null,\"discoveryTime\":1470298180812,\"lastCheckTime\":1470304424090,\"rsTime\":8928,\"website\":\"hidemyass\"},{\"ip\":\"70.248.28.13\",\"port\":8080,\"country\":null,\"discoveryTime\":1470297939447,\"lastCheckTime\":1470304493461,\"rsTime\":689,\"website\":\"hidemyass\"},{\"ip\":\"47.88.104.219\",\"port\":80,\"country\":null,\"discoveryTime\":1470297942307,\"lastCheckTime\":1470304496289,\"rsTime\":2828,\"website\":\"hidemyass\"},{\"ip\":\"209.242.141.60\",\"port\":8080,\"country\":null,\"discoveryTime\":1470298280801,\"lastCheckTime\":1470304525070,\"rsTime\":391,\"website\":\"hidemyass\"},{\"ip\":\"125.39.66.77\",\"port\":80,\"country\":null,\"discoveryTime\":1470299651021,\"lastCheckTime\":1470304610434,\"rsTime\":820,\"website\":\"hidemyass\"},{\"ip\":\"14.161.21.170\",\"port\":8080,\"country\":null,\"discoveryTime\":1470300208911,\"lastCheckTime\":1470304616517,\"rsTime\":5912,\"website\":\"hidemyass\"},{\"ip\":\"212.227.159.39\",\"port\":80,\"country\":null,\"discoveryTime\":1470302188379,\"lastCheckTime\":1470303814836,\"rsTime\":11853,\"website\":\"hidemyass\"},{\"ip\":\"146.148.69.50\",\"port\":80,\"country\":null,\"discoveryTime\":1470303047429,\"lastCheckTime\":1470303864351,\"rsTime\":9337,\"website\":\"hidemyass\"},{\"ip\":\"217.41.242.105\",\"port\":80,\"country\":null,\"discoveryTime\":1470297969362,\"lastCheckTime\":1470303907389,\"rsTime\":277,\"website\":\"free-proxy-list\"},{\"ip\":\"151.236.63.12\",\"port\":80,\"country\":null,\"discoveryTime\":1470297969983,\"lastCheckTime\":1470303917047,\"rsTime\":9658,\"website\":\"free-proxy-list\"},{\"ip\":\"195.62.28.149\",\"port\":80,\"country\":null,\"discoveryTime\":1470297970103,\"lastCheckTime\":1470303917173,\"rsTime\":126,\"website\":\"free-proxy-list\"},{\"ip\":\"31.187.70.37\",\"port\":80,\"country\":null,\"discoveryTime\":1470297970186,\"lastCheckTime\":1470303917255,\"rsTime\":82,\"website\":\"free-proxy-list\"},{\"ip\":\"109.123.100.65\",\"port\":80,\"country\":null,\"discoveryTime\":1470297970267,\"lastCheckTime\":1470303917334,\"rsTime\":79,\"website\":\"free-proxy-list\"},{\"ip\":\"69.70.183.110\",\"port\":80,\"country\":null,\"discoveryTime\":1470300843784,\"lastCheckTime\":1470303940084,\"rsTime\":15453,\"website\":\"spys.ur\"},{\"ip\":\"175.140.249.183\",\"port\":8080,\"country\":null,\"discoveryTime\":1470304024701,\"lastCheckTime\":1470304024701,\"rsTime\":17692,\"website\":\"spys.ur\"},{\"ip\":\"176.126.60.56\",\"port\":8080,\"country\":null,\"discoveryTime\":1470299776449,\"lastCheckTime\":1470304031429,\"rsTime\":1723,\"website\":\"spys.ur\"},{\"ip\":\"109.121.146.159\",\"port\":8080,\"country\":null,\"discoveryTime\":1470301615701,\"lastCheckTime\":1470304061587,\"rsTime\":5894,\"website\":\"spys.ur\"},{\"ip\":\"202.159.6.98\",\"port\":8080,\"country\":null,\"discoveryTime\":1470304137122,\"lastCheckTime\":1470304137122,\"rsTime\":16168,\"website\":\"spys.ur\"},{\"ip\":\"210.56.8.143\",\"port\":8080,\"country\":null,\"discoveryTime\":1470304244097,\"lastCheckTime\":1470304244097,\"rsTime\":17966,\"website\":\"spys.ur\"},{\"ip\":\"198.23.74.170\",\"port\":81,\"country\":null,\"discoveryTime\":1470304294141,\"lastCheckTime\":1470304294141,\"rsTime\":13085,\"website\":\"spys.ur\"}]}";
    private static final String INVALID_JSON = "adfsafafsfaaf";

    @Test
    public void validJsonTest() {
        Response response = JsonParser.parseStringToResponse(VALID_JSON);
        assertTrue(response != null && response.getProxyList() != null && response.getProxyList().size()>0);
    }

    @Test
    public void invalidJsonTest() {
        Response response = JsonParser.parseStringToResponse(INVALID_JSON);
        assertTrue(response != null && response.getProxyList() != null && response.getProxyList().isEmpty());
    }
}
