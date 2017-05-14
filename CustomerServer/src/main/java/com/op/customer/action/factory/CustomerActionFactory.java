package com.op.customer.action.factory;

import com.op.customer.action.customer.CreateCustomerAction;
import com.op.customer.bean.entity.Customer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class CustomerActionFactory extends BaseActionFactory {
    public static CreateCustomerAction getCreateCustomerAction(Customer customer) {
        return new CreateCustomerAction(customer);
    }
}
