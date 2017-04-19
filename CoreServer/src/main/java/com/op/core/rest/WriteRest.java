package com.op.core.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.core.action.factory.WriteActionFactory;
import com.op.core.bean.action.input.DeleteInput;
import com.op.core.bean.action.input.InsertInput;
import com.op.core.bean.action.input.UpdateInput;
import com.op.core.bean.action.output.WriteOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Path("/w/")
@Produces({MediaType.APPLICATION_JSON})
public class WriteRest {
    @POST
    @Path("/{type}")
    public WriteOutput insert(Map o,
                              @PathParam("type") String collectionName) throws Exception {
        InsertInput input = new InsertInput();
        input.setCollectionName(collectionName);
        input.setO(o);
        return (WriteOutput) WriteActionFactory.getInsertAction(input).execute();
    }

    @POST
    @Path("/batch/{type}")
    public WriteOutput inserts(List<Map> os,
                               @PathParam("type") String collectionName) throws Exception {
        InsertInput input = new InsertInput();
        input.setCollectionName(collectionName);
        input.setO(os);
        return (WriteOutput) WriteActionFactory.getInsertsAction(input).execute();
    }

    @DELETE
    @Path("/{type}/{id}")
    public WriteOutput deleteById(@PathParam("type") String collectionName,
                                  @PathParam("id") String id) throws Exception {
        DeleteInput input = new DeleteInput();
        input.setIds(Arrays.asList(id));
        input.setCollectionName(collectionName);
        return (WriteOutput) WriteActionFactory.getDeleteAction(input).execute();
    }

    @DELETE
    @Path("/{type}")
    public WriteOutput deleteByIds(List<String> ids,
                                   @PathParam("type") String collectionName) throws Exception {
        DeleteInput input = new DeleteInput();
        input.setIds(ids);
        input.setCollectionName(collectionName);
        return (WriteOutput) WriteActionFactory.getDeleteAction(input).execute();
    }

    @PUT
    @Path("/{type}/{id}")
    public WriteOutput updateById(Map o,
                                  @PathParam("type") String collectionName,
                                  @PathParam("id") String id) throws Exception {
        UpdateInput input = new UpdateInput();
        input.setCollectionName(collectionName);
        input.setO(o);
        input.setIds(Arrays.asList(id));
        return (WriteOutput) WriteActionFactory.getUpdateAction(input).execute();
    }

    @PUT
    @Path("/{type}")
    public WriteOutput updateByIds(Map o,
                                   @PathParam("type") String collectionName) throws Exception {
        UpdateInput input = new UpdateInput();
        List<String> ids = (List<String>) o.get("ids");
        o.remove("ids");
        input.setCollectionName(collectionName);
        input.setO(o);
        input.setIds(ids);
        return (WriteOutput) WriteActionFactory.getUpdateAction(input).execute();
    }
}