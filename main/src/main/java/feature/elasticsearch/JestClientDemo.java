package main.java.feature.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.junit.jupiter.api.Test;

/**
 * 学习下JestClient
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/4
 */
public class JestClientDemo {

    protected static JestClient client;

    static {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
            new HttpClientConfig.Builder("http://localhost:9200")
                .multiThreaded(true)
                .defaultMaxTotalConnectionPerRoute(2)
                .maxTotalConnection(10)
                .build());
        client = factory.getObject();
    }

    //ping
    //protected static String ping() {
    //    //client.execute()
    //}

    @Test
    public void testConnectivity() {
        System.out.println(client);
    }

    /**
     * create index
     *
     * @return
     */
    protected String createIndex() {
        return "";
    }

    // insert

    // delete

    // search

}