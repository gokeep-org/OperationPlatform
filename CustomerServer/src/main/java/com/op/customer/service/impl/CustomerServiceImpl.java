package com.op.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Customer;
import com.op.customer.bean.entity.ServiceName;
import com.op.customer.service.BaseService;
import com.op.customer.service.CustomerService;
import com.op.util.bean.Paging;
import com.op.util.bean.UriPath;
import com.op.util.common.RequestUtil;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.exception.output.ErrorInfo;
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
        JsonObject json = ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).getAsJsonObject("result");
        return SerializeUtil.gson.fromJson(json, Customer.class);
    }

    @Override
    public List<Customer> searchCustomerList(SearchInput input,  Paging paging) {
        String result;
        //验证
        try {
            Map<String, String> params = new HashMap<>();
            params.put("page_now", String.valueOf(paging.getPageNow()));
            params.put("page_size", String.valueOf(paging.getPageSize()));
            params.put("field", paging.getField());
            params.put("order", paging.getOrder());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/customer/", params, input, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfo("500", "分页获取客户列表失败"));
        }
        if (null != result) {
            return (List) SerializeUtil.transfromStringToList(result);
        }
        return null;
    }

    @Override
    public long searchCustomerTotal() {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/customer/total", getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("total").getAsLong();
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
