package com.op.proxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.op.proxy.config.OperationPlatformException;
import com.op.proxy.service.AuthService;
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
 * @Auther is xuning on 2017/4/21.
 ****************************************/
@Component
public class AuthServiceImpl implements AuthService {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public String getUserId() {
        return httpServletRequest.getHeader("user_id");
    }

    @Override
    public Boolean checkToken(String accessToken, String userId) {
        if (null == accessToken || null == userId) {
            throw new OperationPlatformException("access_token or user_id is null");
        }
        Map params = new HashMap();
        params.put("access_token", accessToken);
        params.put("user_id", userId);

        String url = discoveryVip.choose(ServerName.OAUTH);
        String res = requests.get(url + UriPath.OAUTH + "/token/check", params, getHeaders()).json();
        JsonObject result = (JsonObject) SerializeUtil.transfromStringToObject(res, JsonObject.class);
        try {
            String newAccessToken = result.getAsJsonObject("result").get("access_token").getAsString();
            String success = result.get("success").getAsString();
            if (success.equals("true") && null != newAccessToken) {
                return true;
            }
        } catch (Throwable e) {
            return false;
        }
        return false;
    }

    @Override
    public Boolean checkAccessAuth(String userId, String path, String method) {
//        localhost:60001/user/user/92eb060e-c22c-4bf2-ad45-e18d6a95b81b
        String userResult = requests.get(discoveryVip.choose(ServerName.USER) + UriPath.USER + "/user/" + userId).json();
        if (null == userResult) {
            return false;
        }
        JsonObject result = (JsonObject) SerializeUtil.transfromStringToObject(userResult, JsonObject.class);
        JsonArray jsonArray = result.get("result").getAsJsonObject().get("rule_ids").getAsJsonArray();
//        {{base_ip}}:30001/oauth/auth/search/all
        String eventResult = requests.get(discoveryVip.choose(ServerName.OAUTH) + UriPath.OAUTH + "/auth/search/all").json();

        List<Map> eventList = (List<Map>) SerializeUtil.transfromStringToList(eventResult);
        for (JsonElement jsonElement : jsonArray) {
            String rule_id = jsonElement.getAsString();
            for (Map event : eventList) {
                if (event.get("path").toString().equals(path) && event.get("method").toString().equals(method)) {
                    List<String> list = (List<String>) event.get("rule_ids");
                    for (String ruleId : list) {
                        if (rule_id.equals(ruleId))
                            return true;
                        else
                            continue;
                    }
                }
            }
        }
        return false;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public Requests getRequests() {
        return requests;
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

    public Map getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }

}
