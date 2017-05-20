package com.op.customer.action.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class DeleteCustomerByCustomerIdAction extends ItemAction<ResultMessage> {
    private String customerId;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteCustomerByCustomerIdAction.class);

    public DeleteCustomerByCustomerIdAction(String customerId) {
        this.customerId = customerId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.customerId)
            throw new OperationPlatformException("delete customer by customer id must id is not null");
    }

    @Override
    protected void start() throws Exception {
        customerService.deleteCustomerById(this.customerId);
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
        LOGGER.info(LogMessage.DELETE_CUSTOMER_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.DELETE_CUSTOMER_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
