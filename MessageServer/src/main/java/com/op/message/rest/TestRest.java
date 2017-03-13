package com.op.message.rest;

import com.google.gson.JsonObject;
import com.op.message.bean.entity.email.Email;
import com.op.message.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xuning on 17-2-18.
 */
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class TestRest {
    public String tpf(){
        return "* is tfg";
    }
    @Autowired
    private MailSendService mailSendService;

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
}
