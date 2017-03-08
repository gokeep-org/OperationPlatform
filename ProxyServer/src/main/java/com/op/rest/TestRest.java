package com.op.rest;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.op.util.OpUtils;

import requests.Requests;
import requests.core.RequestImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/10.
 ****************************************/
//TODO: 这里必须添加path路径
@RestController
@RequestMapping("/")
public class TestRest {
    @Autowired
    private static DiscoveryClient discoveryClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(OpUtils.class);

    @RequestMapping(value = "/test")
    public String test(@QueryParam("aaa") String aaa) {

//        String serverUrl = OpUtils.discoveryServerByVipAddress("cloud-client");
        return aaa;
    }
    @RequestMapping("/discovery")
    public String testDiscovery(){
        String serverUrl = OpUtils.discoveryServerByVipAddress("cloud-client_t");
        Requests requests = new RequestImpl();
        String res = requests.get(serverUrl+"/test").text();
        return res;
    }
}
