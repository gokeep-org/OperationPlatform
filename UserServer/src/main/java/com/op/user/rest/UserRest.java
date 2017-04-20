package com.op.user.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.user.bean.entity.user.User;
import com.op.user.service.UserService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {
    @Autowired
    public UserService userService;
    @POST
    public String createUser(User user){
        return userService.createOneUser(user);
    }
}
