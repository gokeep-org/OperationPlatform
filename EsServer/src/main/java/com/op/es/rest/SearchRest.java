package com.op.es.rest;

import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.es.service.IndexService;
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
    private IndexService indexService;
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
    @Path("/index/{index}/type/{type}/id/{id}")
    public String searchDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {
        return indexService.searchIndexById(index, type, id);
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
    @GET
    @Path("/index/{index}/type/{type}")
    public String searchDocumentByDSL(@PathParam("index") String index,
                                      @PathParam("type") String type,
                                      @QueryParam("page_now") @DefaultValue("1") int pageNow,
                                      @QueryParam("page_size") @DefaultValue("10") int pageSize,
                                      @QueryParam("field") @DefaultValue("date") String field,
                                      @QueryParam("order") @DefaultValue("desc") String order) {
        return indexService.pagingSearch(index, type, pageNow, pageSize, field, order);
    }

    /**
     * 通用查询ElasticSearch
     * @param index
     * @param type
     * @param body
     * @return
     */
    @POST
    @Path("/index/{index}/type/{type}")
    public String searchDocumentByCommonQuery(@PathParam("index") String index,
                                              @PathParam("type") String type,
                                              Map body) {
        return indexService.searchIndexByDSL(index, type, body);
    }

    /**
     * 全文搜索
     * @param word
     * @return
     */
    @POST
    @Path("/index/{index}/type/{type}/fulltext")
    public String fullTextSearchByWord(@QueryParam("word") String word) {
        return null;
    }

    /**
     * 聚合查询
     * @return
     */
    @POST
    @Path("/index/{index}/type/{type}/aggs")
    public String searchAggsByQuery() {
        return null;
    }

    /**
     * 直方图查询接口
     * @return
     */
    @POST
    @Path("/index/{index}/type/{type}/histogram")
    public String searchHistogramByQuery(){
        return null;
    }
}
