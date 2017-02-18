package com.op.rest;

import com.op.bean.entity.email.Email;
import com.op.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by xuning on 17-2-18.
 */
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
public class TestRest {
    @Autowired
    private MailSendService mailSendService;

    @Path("/test1")
    @GET
    public String xx() {
        return "{'a':'111'}";
    }

    @Path("/request/header")
    @POST
    public Email testMailAccept(Email email) {
        System.out.println(email.getTitle());
        return email;
    }
}
