package com.op.proxy.util.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.op.proxy.config.OperationPlatformException;
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
public class AuthServiceImpl implements AuthService{
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Override
    public String getUserId() {
        return httpServletRequest.getHeader("user_id");
    }

    @Override
    public Boolean checkToken(String accessToken, String userId) {
        if (null == accessToken || null == userId){
            throw new OperationPlatformException("access_token or user_id is null");
        }
        Map params = new HashMap();
        params.put("access_token", accessToken);
        params.put("user_id", userId);

        String url = discoveryVip.choose(ServerName.OAUTH);
        String res = requests.get(url+ UriPath.OAUTH+"/token/check", params, getHeaders()).json();
        JsonObject result = (JsonObject) SerializeUtil.transfromStringToObject(res, JsonObject.class);
        try {
            String newAccessToken = result.getAsJsonObject("result").get("access_token").getAsString();
            String success = result.get("success").getAsString();
            if (success.equals("true") && null != newAccessToken){
                return true;
            }
        }catch (Throwable e){
            return false;
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
