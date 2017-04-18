package com.op.es.rest;

import com.op.util.requests.Requests;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@Path("/search")
@Produces({MediaType.APPLICATION_JSON})
public class SearchRest {
    @Autowired
    private Requests requests;

    @GET
    @Path("/document/{index}/type/{type}/id/{id}")
    public String searchDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {
        String url = "http://localhost:9200/" + index + "/" + type + "/" + id;
        return requests.get(url).json();
    }

    @GET
    @Path("/document/{index}/type/{type}")
    public String searchAllDocumentByType(@PathParam("index") String index,
                                          @PathParam("type") String type) {

        return null;
    }

    @POST
    @Path("/document/{index}/type/{type}")
    public String searchDocumentByDSL(@PathParam("index") String index,
                                      @PathParam("type") String type) {
        return null;
    }
}
