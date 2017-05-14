package com.op.customer.rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.customer.action.factory.CustomerActionFactory;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.entity.Customer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRest {
    /**
     * 创建学生信息
     * @param customer
     * @return
     * @throws Exception
     */
    @POST
    public ResultMessage createCustomer(Customer customer) throws Exception {
        return CustomerActionFactory.getCreateCustomerAction(customer).execute();
    }

    @DELETE
    @Path("/{id}")
    public ResultMessage deleteCustomerById(@PathParam("id") String customerId) throws Exception {
        return CustomerActionFactory.getDeleteCustomerByCustomerIdAction(customerId).execute();
    }

    @PUT
    @Path("/{id}")
    public ResultMessage updateCustomerById(@PathParam("id") String customerId, Customer customer) throws Exception {
        return CustomerActionFactory.getUpdateCustomerByCustomerIdAction(customerId, customer).execute();
    }
}
