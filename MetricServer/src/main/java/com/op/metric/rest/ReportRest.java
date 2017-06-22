package com.op.metric.rest;

import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/20.
 ****************************************/
@Path("/report")
@Produces(MediaType.APPLICATION_JSON)
public class ReportRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricTestRest.class);
    /**
     * 测试添加度量计数器接口
     * @return
     */
    @POST
    @Path("/test/count/{name}")
    public String test(@PathParam("name") String name,
                       @QueryParam("size") @DefaultValue("1") long size) {
        MetricReportUtil.inc(name, size);
        return "添加度量计数器数据ok";
    }

    /**
     * 测试获取度量计数器大小
     * @param name
     * @return
     */
    @GET
    @Path("/test/count/{name}")
    public String getCounterSize(@PathParam("name") String name){
        return "counter "+name+" total is : "+MetricReportUtil.getCount(name);
    }

    /**
     * 度量数据测试接口
     * @param data
     * @return
     */
    @POST
    @Path("/test")
    public Map test(Map<String, Object> data) {
        LOGGER.info("Receiver: "+new Gson().toJson(data));
        return data;
    }
}
