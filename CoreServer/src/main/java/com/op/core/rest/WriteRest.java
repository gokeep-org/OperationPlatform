package com.op.core.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.core.action.factory.WriteActionFactory;
import com.op.core.bean.action.input.write.InsertInput;
import com.op.core.bean.action.output.WriteOutput;
import com.op.core.bean.entity.BaseBean;

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
    public WriteOutput insert(BaseBean o,
                              @PathParam("type") String collectionName) throws Exception {
        InsertInput input = new InsertInput();
        input.setCollectionName(collectionName);
        input.setO(o);
        return (WriteOutput) WriteActionFactory.getInsertAction(input).execute();
    }

    @POST
    @Path("/batch/{type}")
    public WriteOutput inserts(BaseBean os,
                               @PathParam("type") String collectionName) throws Exception {
        InsertInput input = new InsertInput();
        input.setCollectionName(collectionName);
        input.setO(os);
        return (WriteOutput) WriteActionFactory.getInsertsAction(input).execute();
    }

    @DELETE
    public String deleteById(
            @QueryParam("c_name") String collectionName,
            @QueryParam("id") String id) {
        return null;
    }

    @DELETE
    @Path("/deletes")
    public String deletesByids() {
        return null;
    }
}
