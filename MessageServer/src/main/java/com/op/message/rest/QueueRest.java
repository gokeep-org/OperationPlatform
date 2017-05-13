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
import com.op.message.action.factory.mq.MqActionFactory;
import com.op.message.bean.action.output.ResultMessage;
import com.op.message.library.rabbit.Queue.ServiceName;
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
    @Qualifier(ServiceName.LOG_SENDER)
    public Sender logSender;

    /**
     * 异步插入RabbitMQ消费Log队列存入ElasticSearch
     * 备注：所有的日志都通过异步插入
     * 备注：已经过期，不建议使用费
     * @param body
     * @return
     */
    @POST
    @Path("/log/async")
    public String asyncLog(Map<String, Object> body) {
        JsonObject object = new JsonObject();
        try {
            logSender.send(JSON.toJSONString(body));
        } catch (Throwable e) {
            object.addProperty("success", false);
            return object.toString();
        }
        object.addProperty("success", true);
        return object.toString();
    }

    /**
     * 推送消息到ElasticSearch，统一推送接口
     * @param message
     * @return
     * @throws Exception
     */
    @POST
    @Path("/es/push")
    public ResultMessage pushMessageToElasticsearch(Map<String, Object> message) throws Exception {
        return (ResultMessage) MqActionFactory.getPushMessageToElasticsearchAction(message).execute();
    }
}