package com.op.es.rest;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import com.op.es.util.DiscoveryServer;

import requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@Path("/index")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class IndexRest {
    @Autowired
    private Requests requests;
    @Autowired
    private ElasticsearchTemplate esTemplate;
    @Autowired
    private DiscoveryServer discoveryServer;

    /**
     * 创建文档
     * @param index
     * @param type
     * @return
     */
    @POST
    @Path("/{index}/type/{type}")
    public String createDocument(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 Map<String, Object> map) throws IOException {

        IndexQuery query = new IndexQuery();
        query.setIndexName(index);
        query.setType(type);
        query.setId(UUID.randomUUID().toString());
        query.setObject(map);
        return esTemplate.index(query);
    }

    /**
     * 根据ID删除文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @DELETE
    @Path("/{index}/type/{type}/id/{id}")
    public String deleteDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {
        return esTemplate.delete(index, type, id);
    }

    /**
     * 根据ID更新文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @PUT
    @Path("/{index}/type/{type}/id/{id}")
    public String updateDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {

        return null;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public ElasticsearchTemplate getEsTemplate() {
        return esTemplate;
    }

    public void setEsTemplate(ElasticsearchTemplate esTemplate) {
        this.esTemplate = esTemplate;
    }

    public DiscoveryServer getDiscoveryServer() {
        return discoveryServer;
    }

    public void setDiscoveryServer(DiscoveryServer discoveryServer) {
        this.discoveryServer = discoveryServer;
    }
}
