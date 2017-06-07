package com.op.customer.action.contract;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Contract;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class SearchContractByIdAction extends ItemAction<SearchOutput> {
    private String contractId;
    private Contract contract;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchContractByIdAction.class);

    public SearchContractByIdAction(String contractId) {
        this.contractId = contractId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.contractId)
            throw new OperationPlatformException("search by id must is not null");
    }

    @Override
    protected void start() throws Exception {
        this.contract = contractService.searchContractByCustomerId(this.contractId);
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setResult(this.contract);
        output.setTotal(Objects.equals(null, this.contract) ? 0 : 1);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_CONTRACT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_CONTRACT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
