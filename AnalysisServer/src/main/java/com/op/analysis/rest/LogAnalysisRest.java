package com.op.analysis.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/19.
 ****************************************/

@Path("/log")
@Produces({MediaType.APPLICATION_JSON})
public class LogAnalysisRest {
    @Path("/log")
    public String test(){
        return null;
    }
}
