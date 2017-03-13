package com.op.es.util;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.util.Objects;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/

public class EsClientFactory {
    private static EsClientFactory esClientInstance = new EsClientFactory();
    private static JestClient jestClient;
    private static JestClientFactory jestfactory;
    private EsClientFactory() {
        if (Objects.equals(null, jestfactory)){
            jestfactory = new JestClientFactory();
        }
        jestfactory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        jestClient = jestfactory.getObject();
    }
    public static JestClient getEsClient(){
        if (Objects.equals(null, jestClient)){
            jestClient = jestfactory.getObject();
        }
        return jestClient;
    }

    public static void closeClient() {
        if (!Objects.equals(null, jestClient)){
            jestClient.shutdownClient();
        }
    }
}