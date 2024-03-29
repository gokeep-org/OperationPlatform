package com.op.analysis.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/19.
 ****************************************/
@Path("/message")
@Produces({MediaType.APPLICATION_JSON})
public class MessageAnalysis {

    @Autowired
    public CounterService counterService;

    @GET
    @Path("/inter/count")
    public Map analysisInterfaceAccessCount(){
        return null;
    }
}
