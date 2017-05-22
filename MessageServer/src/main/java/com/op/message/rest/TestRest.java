package com.op.message.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.gson.JsonObject;
import com.op.message.bean.entity.email.Email;
import com.op.message.library.rabbit.sender.Sender;
import com.op.message.service.MailSendService;

/**
 * Created by xuning on 17-2-18.
 */
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class TestRest {
    public String tpf() {
        return "* is tfg";
    }

    @Autowired
    private MailSendService mailSendService;
    @Autowired
    @Qualifier(value = "two_send")
    private Sender sender;
    @Path("/test1")
    @GET
    public String xx() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("test", "ismok");
        return jsonObject.toString();
    }

    @Path("/request/header")
    @POST
    public Email testMailAccept(Email email) {
        System.out.println(email.getTitle());
        return email;
    }
    @Path("/send")
    @GET
    public String send(){
        sender.send("一个测试");
        return "OK";
    }
}
