package com.op.customer.action.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.util.bean.log.MessageLog;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class SearchCustomerTotalAction extends ItemAction<SearchOutput> {
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchCustomerTotalAction.class);

    public SearchCustomerTotalAction() {
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        this.total = customerService.searchCustomerTotal();
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_CUSTOMER_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_CUSTOMER_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
