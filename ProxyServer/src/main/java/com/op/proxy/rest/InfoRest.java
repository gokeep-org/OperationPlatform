package com.op.proxy.rest;

import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/29.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class InfoRest {
    @Path("/info")
    @GET
    public String info(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Get Proxy Server info", "successful");
        return jsonObject.toString();
    }
}
