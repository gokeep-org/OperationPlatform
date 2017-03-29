package com.op.proxy.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;

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
        jsonObject.addProperty("info", "successful");
        return jsonObject.toString();
    }
}
