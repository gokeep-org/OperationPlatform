package com.op.customer.action.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.util.bean.Paging;
import com.op.util.bean.log.MessageLog;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class SearchProductByPagingAction extends ItemAction<SearchOutput> {
    private SearchInput searchBody;
    private Paging paging;
    private List list;
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchProductByPagingAction.class);

    public SearchProductByPagingAction(SearchInput searchBody, Paging paging) {
        this.searchBody = searchBody;
        this.paging = paging;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        if (this.paging.getPageSize() != 0)
            this.list = productService.searchProdustListByPaging(this.searchBody, this.paging);
        this.total = productService.searchProductTotal();
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        output.setList(this.list);
        output.setPageNow(this.paging.getPageNow());
        output.setPageSize(this.paging.getPageSize());
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_PRODUCT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_PRODUCT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
