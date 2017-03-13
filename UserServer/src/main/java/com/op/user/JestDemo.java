package com.op.user;


import com.op.user.util.EsClientFactory;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public class JestDemo {
    public static void main(String[] args) throws Exception {
//
//        JestClientFactory factory = new JestClientFactory();
//        factory.setHttpClientConfig(new HttpClientConfig
//                .Builder("http://localhost:9200")
//                .addServer("http://localhost:9201")
//                .multiThreaded(true)
//                .build());
        JestClient client = EsClientFactory.getEsClient();
        Search search = new Search
                .Builder("")
                .addIndex("customer")
                .addType("info")
                .build();
        SearchResult searchResult = client.execute(search);
        System.out.println(searchResult.getJsonString());
//        client.shutdownClient();
    }

//
//    public static JestClient getRestClient(){
//        JestClientFactory factory = new JestClientFactory();
//        factory.setHttpClientConfig(new HttpClientConfig
//                .Builder("http://localhost:9200")
//                .multiThreaded(true)
//                .build());
//        JestClient client = factory.getObject();
//        return client;
//    }

//    public static void close(){
//
//    }
}
