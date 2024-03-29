package com.op.customer.action.item;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.op.customer.action.BaseAction;
import com.op.customer.bean.action.output.BaseOutput;
import com.op.customer.bean.entity.ServiceName;
import com.op.customer.service.BaseService;
import com.op.customer.service.CommonService;
import com.op.customer.service.ContractService;
import com.op.customer.service.CustomerService;
import com.op.customer.service.ProductService;
import com.op.customer.service.impl.CommonServiceImpl;
import com.op.customer.service.impl.ContractServiceImpl;
import com.op.customer.service.impl.CustomerServiceImpl;
import com.op.customer.service.impl.ProductServiceImpl;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    public CustomerService customerService = BaseService.getService(ServiceName.CUSTOMER_SERVICE, CustomerServiceImpl.class);
    public CommonService commonService = BaseService.getService(ServiceName.COMMMON_SERVICE, CommonServiceImpl.class);
    public ProductService productService = BaseService.getService(ServiceName.PRODUCT_SERVICE, ProductServiceImpl.class);
    public ContractService contractService = BaseService.getService(ServiceName.CONTRACT_SERVICE, ContractServiceImpl.class);

    public String getUserId() {
        return request.getHeader("user_id");
    }
}