package com.op.customer.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.customer.bean.entity.Customer;
import com.op.customer.bean.entity.ServiceName;
import com.op.customer.service.BaseService;
import com.op.customer.service.CustomerService;
import com.op.util.bean.Paging;
import com.op.util.bean.UriPath;
import com.op.util.common.RequestUtil;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
@Service(ServiceName.CUSTOMER_SERVICE)
public class CustomerServiceImpl extends BaseService implements CustomerService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Boolean createCustomer(Customer customer) {
        String result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/customer", customer, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean deleteCustomerById(String customerId) {
        String result = requests.delete(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/customer/" + customerId, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean updateCustomerByCustomerId(String customerId, Customer customer) {
        String result = requests.put(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/customer/" + customerId, customer, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Customer searchCustomerByCustomerId(String customerId) {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/customer/" + customerId, getHeaders()).json();
        return (Customer) SerializeUtil.transfromStringToObject(result, Customer.class);
    }

    @Override
    public List<Customer> searchCustomerList(Customer customer, Paging paging) {
        return null;
    }

    @Override
    public long searchCustomerTotal() {
        return 0;
    }

    @Override
    public long searchRepeatCustomerTotal(Customer customer) {
        return 0;
    }

    public Map<String, String> getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }
}
