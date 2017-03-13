package com.op.user.es.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public class CreateDemo {
    public static void main(String[] args) throws IOException {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")).build();
        //method, endpoint, Collections.emptyMap(), (HttpEntity)null, headers
        HttpEntity entity = new NStringEntity("{\n" +
                "    \"first_name\" :  \"zhao\",\n" +
                "    \"last_name\" :   \"si\",\n" +
                "    \"age\" :         28,\n" +
                "    \"sexname\" : \"男\",\n" +
                "    \"interests\":  [ \"街舞\"],\n" +
                "    \"department_info\": {\n" +
                "      \"department_name\":\"dev\",\n" +
                "      \"position\" : \"beautifuler\"\n" +
                "    }\n" +
                "}", ContentType.APPLICATION_JSON);
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> param = new HashMap<>();
        param.put("prety", "true");
        list.add(param);
        Response response = restClient.performRequest(
                "POST",
                "/customer/info/",
                param,
                entity
        );
        response.getStatusLine().getStatusCode();
        System.out.println(EntityUtils.toString(response.getEntity()));
        restClient.close();
    }
}
