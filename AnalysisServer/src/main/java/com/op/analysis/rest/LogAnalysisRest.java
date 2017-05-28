package com.op.analysis.rest;

import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.analysis.action.factory.LogAnalysisActionFactory;
import com.op.analysis.bean.action.output.SearchOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/19.
 ****************************************/

@Path("/log")
@Produces({MediaType.APPLICATION_JSON})
public class LogAnalysisRest {

    /**
     * 通用日志分析接口
     * 通过ElasticSearch的查询聚合语句-原生
     * 访问该分析服务，通过间接访问ElasticSearch
     * 服务进行数据获取。
     * @return
     */
    @POST
    @Path("{type}")
    public SearchOutput commonLogAnalysis(Map query,
                                          @PathParam("type") String type) throws Exception {
        return LogAnalysisActionFactory.getCommonLogAnalysisAction("log", type, query).execute();
    }
}
