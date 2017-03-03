package com.op.oauth.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.oauth.action.factory.ClientActionFactory;
import com.op.oauth.bean.action.input.client.CreateClientInput;
import com.op.oauth.bean.action.output.client.CreateClientOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
@Path("/client")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ClientRest {
    @POST
    public CreateClientOutput createClient(CreateClientInput input) throws Exception {
        return (CreateClientOutput) ClientActionFactory.getCreateClientAction(input).execute();
    }
}