package com.op.customer.action.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class PagingSearchCustomerAction extends ItemAction<SearchOutput> {
    private SearchInput searchBody;
    private Paging paging;
    private List list;
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(PagingSearchCustomerAction.class);

    public PagingSearchCustomerAction(SearchInput input, Paging paging) {
        this.searchBody = input;
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
            this.list = customerService.searchCustomerList(this.searchBody, this.paging);
        this.total = customerService.searchCustomerTotal();
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        output.setList(this.list);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search customer list is successful");
    }
}
