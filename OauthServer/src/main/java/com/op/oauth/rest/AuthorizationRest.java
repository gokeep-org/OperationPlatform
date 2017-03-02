package com.op.oauth.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("/authorize")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class AuthorizationRest {
    /**
     * 发起授权，这是默认是授权码模式
     * @param client_id
     * @param redirect_uri
     * @param response_type
     * @param state
     * @return
     */
    @GET
    public String authorize(
            @QueryParam("client_id") String client_id,
            @QueryParam("redirect_uri") String redirect_uri,
            @QueryParam("response_type") String response_type,
            @QueryParam("state") String state) {

        return null;
    }

}