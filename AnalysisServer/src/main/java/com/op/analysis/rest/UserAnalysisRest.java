package com.op.analysis.rest;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/19.
 ****************************************/

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 用户分析接口
 * 分析用户行为，用户数据分析
 */
@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
public class UserAnalysisRest {
    @Path("/test")
    public String test() {
        return null;
    }
}
