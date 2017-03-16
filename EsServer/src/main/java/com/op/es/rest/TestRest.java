package com.op.es.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import com.op.es.util.DiscoveryServer;
import com.op.es.util.Server;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryServer discoveryServer;
    @GET
    public String test(){
//      String server_address =  loadBalancerClient.choose("OAUTH").getUri().toString();
//      String res=restTemplate.postForObject("http://OAUTH"+"/test/hello", null, String.class);
//        return "status is ok"+server_address+"and res:"+res;
        return "OK";
    }
    @Path("/discovery")
    @GET
    public String discoveryServer(){
        return discoveryServer.getServerAddress(Server.CUSTOMER_SERVER);
    }


}