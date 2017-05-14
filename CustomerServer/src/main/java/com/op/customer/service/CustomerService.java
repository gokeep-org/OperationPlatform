package com.op.customer.service;

import com.op.customer.bean.entity.Customer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public interface CustomerService {
    // 创建用户
    public Boolean createCustomer(Customer customer);
}
