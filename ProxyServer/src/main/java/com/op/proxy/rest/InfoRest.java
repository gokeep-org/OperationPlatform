package com.op.proxy.rest;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/29.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class InfoRest {
    @Autowired
    Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Path("/info")
    @GET
    public String info() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Get Proxy Server info", "successful");
        return jsonObject.toString();
    }
    @GET
    @Path("/test/core")
    public String testCOre(){
        User user = new User();
        user.setUsername("宁哥");
        user.setPassword(UUID.randomUUID().toString());
        user.setPhones(Arrays.asList(new String[]{"1111", "22222"}));
        Map<String,String> header = new HashedMap();
        header.put("Content-Type", "application/json");
        String server = discoveryVip.choose(ServerName.CORE);
        return requests.post(server + "/w/user", user, header).json();

    }
}
