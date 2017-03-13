package com.op.user.es.example;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public class Demo {
    public static void main(String[] args) throws IOException {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")).build();
        //method, endpoint, Collections.emptyMap(), (HttpEntity)null, headers
        Response response = restClient.performRequest(
                "GET",
                "/customer/info/_search",
                Collections.singletonMap("pretty", "true")
        );
        response.getStatusLine().getStatusCode();
        System.out.println(EntityUtils.toString(response.getEntity()));
        restClient.close();
    }
}
