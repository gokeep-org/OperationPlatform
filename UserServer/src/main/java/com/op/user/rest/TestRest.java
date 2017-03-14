package com.op.user.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/14.
 ****************************************/
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestRest {
    @GET
    public String test(){
        return "user server sttus is ok";
    }
    @GET
    @Path("/test1")
    public String test2(){
        return "test";
    }
}
