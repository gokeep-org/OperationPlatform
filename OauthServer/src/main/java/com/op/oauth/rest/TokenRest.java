package com.op.oauth.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.oauth.action.factory.TokenActionFactory;
import com.op.oauth.bean.action.input.token.CreateTokenInput;
import com.op.oauth.bean.action.output.token.CreateTokenOutput;

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
    @GET
    public CreateTokenOutput createToken(
            @QueryParam("grant_type") @DefaultValue("password") String grantType,
            @QueryParam("redirect_uri") String redirectUri,
            @QueryParam("refresh_token") String refreshToke,
            @QueryParam("username") String userName,
            @QueryParam("password") String password,
            @QueryParam("code") String code,
            @HeaderParam("authorization") String authorization) throws Exception {
        CreateTokenInput input = new CreateTokenInput();
        input.setGrantType(grantType);
        input.setAuthorization(authorization);
        input.setCode(code);
        input.setPassword(password);
        input.setRedirectUri(redirectUri);
        input.setRefreshToke(refreshToke);
        input.setCode(code);
        input.setUserName(userName);
        return (CreateTokenOutput) TokenActionFactory.getCreateTokenAction(input).execute();
    }
}