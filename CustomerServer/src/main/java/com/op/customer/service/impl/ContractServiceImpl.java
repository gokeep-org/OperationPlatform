package com.op.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Contract;
import com.op.customer.bean.entity.ServiceName;
import com.op.customer.service.BaseService;
import com.op.customer.service.ContractService;
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
 * @Auther is xuning on 2017/6/7.
 ****************************************/
@Service(ServiceName.CONTRACT_SERVICE)
public class ContractServiceImpl extends BaseService implements ContractService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Boolean createContract(Contract contract) {
        String result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/contract", contract, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean deleteContractById(String contractId) {
        String result = requests.delete(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/contract/" + contractId, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean updateContractByContractId(String contractId, Contract contract) {
        String result = requests.put(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/contract/" + contractId, contract, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Contract searchContractByCustomerId(String contractId) {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/contract/" + contractId, getHeaders()).json();
        JsonObject json = ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).getAsJsonObject("result");
        return SerializeUtil.gson.fromJson(json, Contract.class);
    }

    @Override
    public List<Contract> searchContractList(SearchInput input, Paging paging) {
        String result;
        //验证
        try {
            Map<String, String> params = new HashMap<>();
            params.put("page_now", String.valueOf(paging.getPageNow()));
            params.put("page_size", String.valueOf(paging.getPageSize()));
            params.put("field", paging.getField());
            params.put("order", paging.getOrder());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/contract/", params, input, getHeaders()).json();
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
    public long searchContractTotal() {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/contract/total", getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("total").getAsLong();
    }

    public Map<String, String> getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }
}
