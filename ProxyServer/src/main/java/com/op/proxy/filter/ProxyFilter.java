package com.op.proxy.filter;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.op.proxy.bean.ServerName;
import com.op.proxy.config.OperationPlatformException;
import com.op.util.requests.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import requests.Requests;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/8.
 ****************************************/
@Configuration
public class ProxyFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyFilter.class);
    @Autowired
    public Requests requests;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String accessToken  = ctx.getRequest().getParameter("access_token");
        String userId = ctx.getRequest().getParameter("user_id");
        //TODO: 这里要对token和user_id进行校验,请求Oauth2
        String url = loadBalancerClient.choose(ServerName.OAUTH).getUri()+"/token/check";
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("user_id", userId);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String res = requests.get(url, params, headers).json();
        JsonObject r = new Gson().fromJson(res, JsonObject.class);
        String success = r.get("success").getAsString();
        if (!r.get("success").getAsString().equals("true")){
            ctx.setResponseStatusCode(500);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msg", "token为空或者过期");
            jsonObject.addProperty("code", 500);
            jsonObject.addProperty("success", false);
            jsonObject.addProperty("uuid", UUID.randomUUID().toString());
            ctx.setResponseBody(jsonObject.toString());
            throw new OperationPlatformException("token is invoid or null");
        }
        return null;
    }

    public LoadBalancerClient getLoadBalancerClient() {
        return loadBalancerClient;
    }

    public void setLoadBalancerClient(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }
}