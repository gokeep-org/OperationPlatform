package com.op.oauth.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.oauth.bean.entity.Client;
import com.op.oauth.bean.entity.Rule;
import com.op.oauth.bean.entity.User;
import com.op.oauth.service.AuthService;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;
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
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.AUTHORIZATION_SERVICE)
public class AuthServiceImpl extends BaseService implements AuthService<Client, User> {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Override
    public Client authorization(User user) {
        return null;
    }

    @Override
    public Boolean checkUserAccessAuth(String path, String method, String userId) {
        //TODO: 验证用户访问权限
        String resTotal = requests.get(discoveryVip.choose(ServerName.CORE)+UriPath.CORE+"/read/user/total").json();
        long total = ((JsonObject)SerializeUtil.transfromStringToObject(resTotal, JsonObject.class)).get("total").getAsLong();
        if (total == 0)
            return false;
        Map<String, String> params = new HashMap<>();
        params.put("page_now", "1");
        params.put("page_size", String.valueOf(total));
        params.put("field", "id");
        params.put("order", "descend");
        Map<String, String> headers = new HashMap<>();
        String result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/rule/", params).json();
        return null;
    }
    @Override
    public Boolean createRule(Rule rule){
        String res = requests.post(discoveryVip.choose(ServerName.CORE)+UriPath.CORE+"/write/rule", rule, getHeaders()).json();
        Boolean result = false;
        try{
            result = ((JsonObject)SerializeUtil.transfromStringToObject(res, JsonObject.class)).get("success").getAsBoolean();
        }catch (Throwable e){
            return false;
        }
        return result;
    }

    public Requests getRequests() {
        return requests;
    }


    public Map<String, String> getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }


    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public DiscoveryVip getDiscoveryVip() {
        return discoveryVip;
    }

    public void setDiscoveryVip(DiscoveryVip discoveryVip) {
        this.discoveryVip = discoveryVip;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
}
