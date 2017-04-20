package com.op.core.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.core.action.factory.ReadActionFactory;
import com.op.core.bean.action.input.SearchInput;
import com.op.core.bean.action.output.ReadOutput;

import io.swagger.annotations.ApiOperation;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Path("/read")
@Produces({MediaType.APPLICATION_JSON})
public class ReadRest {
    @ApiOperation(value = "cdscds")
    @GET
    @Path("/{type}/{id}")
    public ReadOutput searchDocumentById(@PathParam("type") String collectionName,
                                         @PathParam("id") String id) throws Exception {
        SearchInput input = new SearchInput();
        input.setCollectionName(collectionName);
        input.setId(id);
        return (ReadOutput) ReadActionFactory.getSearchDocumentByIdAction(input).execute();
    }

    @POST
    @Path("/{type}")
    public ReadOutput searchDocumentByQuery(SearchInput input,
                                            @PathParam("type") String collectionName) throws Exception {
        input.setCollectionName(collectionName);
        return (ReadOutput) ReadActionFactory.getSearchDocumentBytermAction(input).execute();
    }

    @GET
    @Path("/{type}/size")
    public ReadOutput searchCollectionSize(@PathParam("type") String collectionNmae) throws Exception {
        return (ReadOutput) ReadActionFactory.getSearchCollectionSizeAction(null, collectionNmae).execute();
    }
}
