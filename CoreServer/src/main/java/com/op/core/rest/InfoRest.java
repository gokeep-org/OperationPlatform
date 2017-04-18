package com.op.core.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/18.
 ****************************************/
@Path("/info")
@Produces({MediaType.APPLICATION_JSON})
public class InfoRest {
    @GET
    public String info(){
        JsonObject object = new JsonObject();
        object.addProperty("status", "is health");
        return object.toString();
    }
}
