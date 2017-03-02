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
    @POST
    public String token(
            @QueryParam("grant_type") @DefaultValue("password") String grantType,
            @QueryParam("redirect_uri") String redirectUri,
            @QueryParam("code") String code,
            @QueryParam("refresh_token") String refreshToke,
            @HeaderParam("authorization") String authorization){
        if (grantType.equals("authorization_code")){
            //authorization_code mode
        }

        //password mode
        return "ok";
    }
}