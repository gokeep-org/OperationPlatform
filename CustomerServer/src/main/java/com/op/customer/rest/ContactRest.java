package com.op.customer.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Contact;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/21.
 ****************************************/
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactRest {

    /**
     * 创建联系方式
     * @param contact
     * @return
     */
    @POST
    public ResultMessage createContact(Contact contact) {
        return null;
    }

    /**
     * 根据联系ID删除联系方式
     * @return
     */
    @DELETE
    public ResultMessage deleteContactById() {
        return null;
    }

    /**
     * 根据联系方式ID更新联系方式
     * @param contactId
     * @return
     */
    @PUT
    public ResultMessage updateContactByContactId(@QueryParam("id") String contactId) {
        return null;
    }

    /**
     * 根据ID查询联系方式
     * @param contactId
     * @return
     */
    @GET
    public SearchOutput searchContactByContactId(@QueryParam("id") String contactId) {
        return null;
    }
}
