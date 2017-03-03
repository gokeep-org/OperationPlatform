package com.op.oauth.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.oauth.action.factory.ClientActionFactory;
import com.op.oauth.bean.action.input.client.CreateClientInput;
import com.op.oauth.bean.action.input.client.DeleteClientInput;
import com.op.oauth.bean.action.input.client.GetClientInput;
import com.op.oauth.bean.action.input.client.UpdateClientInput;
import com.op.oauth.bean.action.output.client.CreateClientOutput;
import com.op.oauth.bean.action.output.client.DeleteClientOutput;
import com.op.oauth.bean.action.output.client.GetClientOutput;
import com.op.oauth.bean.action.output.client.UpdateClientOutput;

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
    /**
     * 根据ClientId获取客户端信息
     * @param clientId
     * @return
     * @throws Exception
     */
    @GET
    public GetClientOutput getClientByClientId(@QueryParam("client_id") String clientId) throws Exception {
        GetClientInput input = new GetClientInput();
        input.setClientId(clientId);
        return (GetClientOutput) ClientActionFactory.getClientAction(input).execute();
    }

    /**
     * 创建一个新的客户端
     * @param client
     * @return
     * @throws Exception
     */
    @POST
    public CreateClientOutput createClient(CreateClientInput client) throws Exception {
        return (CreateClientOutput) ClientActionFactory.getCreateClientAction(client).execute();
    }

    /**
     * 更新客户端
     * @param input
     * @return
     * @throws Exception
     */
    @PUT
    public UpdateClientOutput updateClient(UpdateClientInput input) throws Exception {
        return (UpdateClientOutput) ClientActionFactory.getUpdateClientAction(input).execute();
    }

    /**
     * 删除指定的客户端
     * @param clientIds
     * @return
     * @throws Exception
     */
    @DELETE
    public DeleteClientOutput deleteClient(List<String> clientIds) throws Exception {
        DeleteClientInput input = new DeleteClientInput();
        input.setClientIds(clientIds);
        return (DeleteClientOutput) ClientActionFactory.getDeleteClientAction(input).execute();
    }


}