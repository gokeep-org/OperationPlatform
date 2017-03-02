package com.op.oauth.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/1.
 ****************************************/
@Path("/token")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TokenRest {
    /**
     * 获取token，支持授权码和密码两种方式
     * @param grantType
     * @param redirectUri
     * @param code
     * @param refreshToke
     * @param authorization
     * @return
     */
    @POST
    public String token(
            @QueryParam("grant_type") @DefaultValue("password") String grantType,
            @QueryParam("redirect_uri") String redirectUri,
            @QueryParam("refresh_token") String refreshToke,
            @QueryParam("username") String userName,
            @QueryParam("password") String password,
            @QueryParam("code") String code,
            @HeaderParam("authorization") String authorization) {
        if (grantType.equals("authorization_code")) {
            //authorization_code mode
        }
        //这里是默认使用密码模式
        return "ok";
    }
}