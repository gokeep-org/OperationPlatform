package com.op.es.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.util.requests.Requests;


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

    /**
     * 根据索引/类型/ID查询指定文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @GET
    @Path("/document/{index}/type/{type}/id/{id}")
    public String searchDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {
        String url = "http://localhost:9200/" + index + "/" + type + "/" + id;
        return requests.get(url).json();
    }

    /**
     * 查询指定类型下的所有文档
     * @param index
     * @param type
     * @return
     */
    @GET
    @Path("/document/{index}/type/{type}")
    public String searchAllDocumentByType(@PathParam("index") String index,
                                          @PathParam("type") String type) {

        return null;
    }

    /**
     * 通过DSL语句查询文档
     * @param index
     * @param type
     * @return
     */
    @POST
    @Path("/document/{index}/type/{type}")
    public String searchDocumentByDSL(@PathParam("index") String index,
                                      @PathParam("type") String type) {
        return null;
    }
}
