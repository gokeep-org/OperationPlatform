package com.op.user.util;

import java.io.IOException;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public class EsClient {
    private static EsClient esClientInstance = new EsClient();

    private static JestClientFactory jestfactory = new JestClientFactory();

    public static JestClient jestClient;

    private EsClient() {
        if (null == esClientInstance) {
            esClientInstance = new EsClient();
        }
        jestfactory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        jestClient = jestfactory.getObject();
    }

    public static EsClient getInstance() {
        return esClientInstance;
    }

    public static SearchResult searchAll(String index, String type, String... params) throws IOException {
        Search search = new Search
                .Builder("")
                .addIndex(index)
                .addType(type)
                .build();
        SearchResult searchResult = jestClient.execute(search);

        return searchResult;
    }

    public static void closeClient() {
        jestClient.shutdownClient();
    }
}
