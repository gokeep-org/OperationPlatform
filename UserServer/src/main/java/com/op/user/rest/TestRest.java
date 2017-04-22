package com.op.user.rest;

import com.op.util.requests.Requests;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    @Autowired
    private Requests requests;

    @Path("/info")
    @GET
    public String info() {
        return requests.get("http://www.baidu.com").text();
    }
}