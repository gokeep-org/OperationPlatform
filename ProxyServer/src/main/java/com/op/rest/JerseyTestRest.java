package com.op.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/7.
 ****************************************/
@Path("/jersey")
public class JerseyTestRest {
    @GET
    @Path("/test")
    public String test(){
        return "ok";
    }
}
