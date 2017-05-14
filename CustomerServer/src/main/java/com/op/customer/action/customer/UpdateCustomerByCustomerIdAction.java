package com.op.customer.action.customer;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.entity.Customer;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class UpdateCustomerByCustomerIdAction extends ItemAction<ResultMessage> {
    private String customerId;
    private Customer customer;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateCustomerByCustomerIdAction.class);

    public UpdateCustomerByCustomerIdAction(String customerId, Customer customer) {
        this.customerId = customerId;
        this.customer = customer;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.customerId)
            throw new OperationPlatformException("update customer must id is not null");
        if (Objects.equals(null, this.customer))
            throw new OperationPlatformException("update customer body customer must is not null");
    }

    @Override
    protected void start() throws Exception {
        customerService.updateCustomerByCustomerId(this.customerId, this.customer);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("delete customer is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("update customer is successful");
    }
}
