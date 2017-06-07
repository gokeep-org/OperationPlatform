package com.op.customer.action.contract;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.entity.Contract;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class CreateContractAction extends ItemAction<ResultMessage> {
    private Contract contract;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateContractAction.class);

    public CreateContractAction(Contract contract) {
        this.contract = contract;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, contract))
            throw new OperationPlatformException("create contract must contract is not null");
        this.contract.setCreateTime(new Date().getTime());
        this.contract.setId(UUID.randomUUID().toString());
        this.contract.setStatus((true));
    }

    @Override
    protected void start() throws Exception {
        contractService.createContract(this.contract);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setSuccess(true);
        resultMessage.setMesssage("create contract is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.CREATE_CONTRACT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.CREATE_CONTRACT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
