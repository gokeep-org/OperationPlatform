package com.op.customer.service;

import java.util.List;

import com.op.customer.bean.entity.Customer;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public interface CustomerService {
    /**
     * 创建客户信息
     * @param customer
     * @return
     */
    public Boolean createCustomer(Customer customer);

    /**
     * 通过customerId删除客户信息
     * @param customerId
     * @return
     */
    public Boolean deleteCustomerById(String customerId);

    /**
     * 通过客户Id更新客户信息
     * @param customer
     * @return
     */
    public Boolean updateCustomerByCustomerId(String customerId, Customer customer);

    /**
     * 通过客户端Id查询客户信息
     * @param customerId
     * @return
     */
    public Customer searchCustomerByCustomerId(String customerId);

    /**
     * 分页查询客户列表信息
     * @param customer
     * @param paging
     * @return
     */
    public List<Customer> searchCustomerList(Customer customer, Paging paging);

    /**
     * 查询客户总数
     * @return
     */
    public long searchCustomerTotal();

    /**
     * 查询重复客户数目
     * @param customer
     * @return
     */
    public long searchRepeatCustomerTotal(Customer customer);
}
