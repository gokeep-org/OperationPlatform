package com.op.proxy.util.auth;

import com.google.gson.JsonObject;
import com.op.proxy.config.OperationPlatformException;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

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
        String res = requests.get(url+"/oauth/token/check", params, getHeaders()).json();
        JsonObject result = (JsonObject) SerializeUtil.transfromStringToObject(res, JsonObject.class);
        String success = result.get("success").getAsString();
        if (success.equals("true")){
            return true;
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

    private Map getHeaders() {
        final Map headers = new HashMap();
        headers.put("Content-Type", MediaType.APPLICATION_JSON);
        headers.put("Accept", MediaType.APPLICATION_JSON);
        headers.put("user_id", httpServletRequest.getHeader("user_id"));
        return headers;
    }
    

}
