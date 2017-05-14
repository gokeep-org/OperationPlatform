package com.op.customer.action.customer;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Customer;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class SearchCustomerByCustomerIdAction extends ItemAction<SearchOutput> {
    private String customerId;
    private Customer result;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchCustomerByCustomerIdAction.class);

    public SearchCustomerByCustomerIdAction(String customerId) {
        this.customerId = customerId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.customerId)
            throw new OperationPlatformException("search customer by id must id is not null");
    }

    @Override
    protected void start() throws Exception {
        this.result = customerService.searchCustomerByCustomerId(this.customerId);
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setResult(this.result);
        output.setTotal(Objects.equals(null, this.result) ? 0 : 1);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search customer by customer id is successful");
    }
}
