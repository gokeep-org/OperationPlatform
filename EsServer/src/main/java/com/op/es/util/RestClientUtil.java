//package com.op.es.util;
//
//import java.util.Arrays;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/14.
// ****************************************/
//@Component
//public class RestClientUtil {
//    /**
//     * 这里的url都要使用服务名称
//     */
//    @Autowired
//    private RestTemplate restTemplate;
//    private static final Logger LOGGER = LoggerFactory.getLogger(RestClientUtil.class);
//
//    public String get(String url) {
//        return restTemplate.getForObject(url, String.class);
//    }
//
//    public String get(String url, Map<String, String> params) {
//        return restTemplate.getForObject(url, String.class, params);
//    }
//
//    public String get(String url, Map<String, String> params, Map<String, String> headers) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        headers.entrySet().forEach(header -> {
//            httpHeaders.put(header.getKey(), Arrays.asList(header.getValue()));
//        });
//        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
//        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params).getBody();
//    }
//
//    public String post(String url) {
//        return restTemplate.postForObject(url, null, String.class);
//    }
//
//    public String post(String url, Map<String, String> params) {
//        return restTemplate.postForObject(url, null, String.class, params);
//    }
//
//    public String post(String url, Map<String, String> params, Map<String, String> headers) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        headers.entrySet().forEach(header -> {
//            httpHeaders.put(header.getKey(), Arrays.asList(header.getValue()));
//        });
//        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
//        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class, params).getBody();
//    }
//
//    public String put(String url) {
//        try {
//            restTemplate.put(url, null);
//        } catch (Exception e) {
//            LOGGER.error("发送put请求错误，url:" + url);
//        }
//        return "true";
//    }
//
////    public static String put(String url, Map<String, String> params, )
//
//}