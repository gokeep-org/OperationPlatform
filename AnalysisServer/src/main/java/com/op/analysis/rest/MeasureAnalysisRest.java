package com.op.analysis.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.analysis.service.MeasureAnalysisService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/25.
 ****************************************/
@Path("/measure")
@Produces({MediaType.APPLICATION_JSON})
public class MeasureAnalysisRest {
    @Autowired
    private MeasureAnalysisService measureAnalysisService;
    @GET
    public String test(){
        return "success";
    }

    @GET
    @Path("/node/{name}")
    public Map searchNodeHealth(@PathParam("name") String name){
        return measureAnalysisService.searchNodeHealthy(name);
    }
}
