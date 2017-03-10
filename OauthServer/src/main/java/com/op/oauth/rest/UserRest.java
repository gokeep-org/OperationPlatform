package com.op.oauth.rest;

import com.op.oauth.action.factory.UserActionFactory;
import com.op.oauth.bean.action.input.user.CreateUserInput;
import com.op.oauth.bean.action.input.user.GetUserInput;
import com.op.oauth.bean.action.output.user.CreateUserOutput;
import com.op.oauth.bean.action.output.user.GetUserOutput;
import com.op.oauth.bean.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/1.
 ****************************************/
@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserRest {
    /**
     * 创建一个用户
     * @param
     * @param user
     * @return
     */
    @POST
    public CreateUserOutput createUser(CreateUserInput user) throws Exception {
        return (CreateUserOutput) UserActionFactory.getCreateAction(user).execute();
    }

    /**
     * 更新用户
     * @param user
     * @param
     * @return
     */
    @PUT
    public String updateUser(User user){
        return null;
    }

    /**
     * 删除用户
     * @param userId
     * @param
     * @return
     */
    @DELETE
    public String deleteUser(@QueryParam("user_id") String userId){
        return null;
    }

    /**
     * 获取用户信息
     * @param
     * @return
     */
    @GET
    public GetUserOutput getUser(@QueryParam("user_id") String userId) throws Exception {
        GetUserInput input = new GetUserInput();
        input.setId(userId);
        return (GetUserOutput) UserActionFactory.getUserAction(input).execute();
    }

    /**
     * 获取权限下的所有的用户
     * @param
     * @return
     */

    @GET
    @Path("/all")
    public String getAllUser(){
        return null;
    }

    /**
     * 验证用户的的合法性和权限信息
     * @param user
     * @return
     */
    @POST
    @Path("/check")
    public String checkUser(User user){
        return null;
    }

    /**
     * 冻结该用户
     * @param userId
     * @return
     */
    @PUT
    @Path("/freeze")
    public String freezeUser(@QueryParam("user_id") String userId){
        return null;
    }
}
