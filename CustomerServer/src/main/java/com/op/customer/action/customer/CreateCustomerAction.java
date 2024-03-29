package com.op.customer.action.customer;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.entity.Customer;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class CreateCustomerAction extends ItemAction<ResultMessage> {

    private Customer customer;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCustomerAction.class);

    public CreateCustomerAction(Customer customer) {
        this.customer = customer;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.customer))
            throw new OperationPlatformException("create customer must customer is not null");
        this.customer.setId(UUID.randomUUID().toString());
        this.customer.setStatus(true);
        this.customer.setCreateTime(new Date().getTime());
        //TODO: 还需要校验当前客户是否已经存在
    }

    @Override
    protected void start() throws Exception {
        customerService.createCustomer(this.customer);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setSuccess(true);
        resultMessage.setMesssage("create customer is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.CREATE_CUSTOMER_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.CREATE_CUSTOMER_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
