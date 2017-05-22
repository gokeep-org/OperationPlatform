//package com.op.es.util;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.stereotype.Component;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/15.
// ****************************************/
//@Component
//public class DiscoveryServer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryServer.class);
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    public String getServerAddress(String serverName) {
//        List<String> list = Server.getServerList();
//        if (!list.contains(serverName)) {
//            LOGGER.error("server not exist server list");
//        }
//        return loadBalancerClient.choose(serverName).getUri().toString();
//    }
//}