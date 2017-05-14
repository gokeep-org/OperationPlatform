package com.op.customer.action.customer;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.action.output.BaseOutput;
import com.op.customer.bean.entity.Customer;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class SearchCustomerByCustomerIdAction extends ItemAction<BaseOutput> {
    private String customerId;
    private Customer customer;

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
        this.customer = customerService.searchCustomerByCustomerId(this.customerId);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return null;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
