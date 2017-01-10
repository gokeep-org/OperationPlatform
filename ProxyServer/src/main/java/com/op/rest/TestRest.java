package com.op.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/10.
 ****************************************/
//TODO: 这里必须添加path路径
@Path("/")
public class TestRest {
    @GET
    @Path("/test")
    public String test(){
        return "Hello World";
    }
}
