package com.op.oauth.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import com.google.gson.JsonObject;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/28.
 ****************************************/
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @POST
    @Path("/hello")
    public String test() {
//        ServiceInstance instance = loadBalancerClient.choose("oauth");
//        System.out.println(instance.getHost()+":"+instance.getPort());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uri", "ok");
        return jsonObject.toString();
    }
}