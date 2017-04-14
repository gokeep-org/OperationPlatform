package com.op.core.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.op.core.util.discovery.DiscoveryClient;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    @Path("/info")
    @GET
    public String info() {
        String s = DiscoveryClient.choose("oauth");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("oauth", s);
        return jsonObject.toString();
    }

    @Path("/test")
    @GET
    public String test() {
        String s = DiscoveryClient.choose("proxy");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("proxy", s);
        return jsonObject.toString();
    }

    @Path("/test1")
    @GET
    public String test1() {
        JsonObject obj  = new JsonObject();
        obj.addProperty("INFO", "this is test1");
        return obj.toString();
    }


}
