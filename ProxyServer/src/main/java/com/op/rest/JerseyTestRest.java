package com.op.rest;


import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.op.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/7.
 ****************************************/
@Path("/jersey")
public class JerseyTestRest {
    @GET
    @Path("/test")
    public String test(){
        Map<String, Object> map = new HashMap();
        map.put("aaa", "bbb");
        return "";
    }
    @GET
    @Path("/test2")
    public String test1(){
        String url = OpUtils.discoveryServerByVipAddress("proxy");
        return url;
    }
}
