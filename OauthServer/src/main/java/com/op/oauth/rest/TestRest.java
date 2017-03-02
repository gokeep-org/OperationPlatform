package com.op.oauth.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.op.oauth.bean.entity.User;
import com.op.oauth.dao.UserMapper;

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
    private UserMapper mapper;

    @GET
    @Path("/hello")
    public String test() {
        User user = mapper.selectByPrimaryKey(1);
        JsonObject obj = new JsonObject();
//        obj.addProperty("name", user.getName());
        return obj.toString();
    }
}
