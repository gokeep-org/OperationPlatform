package com.op.core.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Path("/r")
@Produces({MediaType.APPLICATION_JSON})
public class ReadRest {
    @Path("/read")
    public String test(){
        return null;
    }
}
