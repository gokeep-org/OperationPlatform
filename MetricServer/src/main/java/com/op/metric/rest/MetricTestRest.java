package com.op.metric.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/21.
 ****************************************/
@Path("/m")
@Produces(MediaType.APPLICATION_JSON)
public class MetricTestRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricTestRest.class);

    @POST
    @Path("/test")
    public Map test(Map map) {
        Map m = new HashMap();
        m.put("aa", "111");
        LOGGER.info(m.toString());
        return m;
    }
}
