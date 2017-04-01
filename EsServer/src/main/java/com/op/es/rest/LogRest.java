package com.op.es.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import com.op.es.bean.Log;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Path("/log")
public class LogRest {
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Path("/info")
    @POST
    public String saveLog(Log log) {
        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setIndexName("log");
        indexQuery.setType("info");
        indexQuery.setObject(log);
        return esTemplate.index(indexQuery);
    }

    public ElasticsearchTemplate getEsTemplate() {
        return esTemplate;
    }

    public void setEsTemplate(ElasticsearchTemplate esTemplate) {
        this.esTemplate = esTemplate;
    }
}
