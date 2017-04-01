package com.op.message.rest;

import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.op.message.library.rabbit.Queue.SenderName;
import com.op.message.library.rabbit.sender.Sender;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/31.
 ****************************************/
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class QueueRest {
    @Autowired
    @Qualifier(SenderName.LOG_SENDER)
    public Sender logSender;

    @POST
    @Path("/log/async")
    public String asyncLog(Map<String, Object> body) {
        logSender.send(JSON.toJSONString(body));
        JsonObject object = new JsonObject();
        object.addProperty("success", true);
        return object.toString();
    }
}
