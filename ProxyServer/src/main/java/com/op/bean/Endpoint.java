package com.op.bean;

import javax.ws.rs.GET;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/10.
 ****************************************/
public class Endpoint {


    @GET
    public String message() {
        return "Hello ";
    }
}
