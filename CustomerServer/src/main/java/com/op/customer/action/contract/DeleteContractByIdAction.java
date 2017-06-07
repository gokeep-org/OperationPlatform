package com.op.customer.action.contract;

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
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class DeleteContractByIdAction extends ItemAction<ResultMessage> {
    private String contractId;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteContractByIdAction.class);

    public DeleteContractByIdAction(String contractId) {
        this.contractId = contractId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.contractId)
            throw new OperationPlatformException("delete contract id must is not null");
    }

    @Override
    protected void start() throws Exception {
        contractService.deleteContractById(this.contractId);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("delete contract is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.DELETE_CONTRACT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.DELETE_CONTRACT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
