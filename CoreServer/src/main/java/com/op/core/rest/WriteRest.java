package com.op.core.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.core.service.WriteService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Path("/w")
@Produces({MediaType.APPLICATION_JSON})
public class WriteRest {
    @Autowired
    private WriteService writeService;
    @POST
    public String insert(Object o) {
        try{
            writeService.insert(o);
        }catch (Exception e){
            return "";
        }
        return null;
    }

    @POST
    @Path("/batch")
    public String inserts(List<Object> os) {
        return null;
    }

    @DELETE
    public String deleteById(String collectionName, String id){
        return null;
    }

    @DELETE
    @Path("/deletes")
    public String deletesByids(){
     return null;
    }
}
