package com.op.proxy.filter;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.google.gson.JsonObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.op.proxy.config.OperationPlatformException;
import com.op.proxy.util.auth.AuthService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/8.
 ****************************************/
@Configuration
public class ZuulRequestFilter extends ZuulFilter {

    @Autowired
    private AuthService authService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulRequestFilter.class);
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


    /**
     * 通过网关之前需要进行权限校验
     * @return
     */
    @Override
    public Object run() {
        LOGGER.info("proxt request is user");
        RequestContext ctx = RequestContext.getCurrentContext();
        String accessToken = ctx.getRequest().getHeader("access_token");
        String userId = ctx.getRequest().getHeader("user_id");
        if (null == accessToken || null == userId)
            buildAuthErrorInfoToRequestContext(ctx);
        if (authService.checkToken(accessToken, userId)) {
            return null;
        } else {
            buildAuthErrorInfoToRequestContext(ctx);
            throw new OperationPlatformException("token is exprise in");
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void buildAuthErrorInfoToRequestContext(RequestContext ctx) {
        ctx.setResponseStatusCode(500);
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=utf-8");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("msg", "token过期或者为空");
        jsonObject.addProperty("code", 500);
        jsonObject.addProperty("success", false);
        String uuidCode = UUID.randomUUID().toString();
        jsonObject.addProperty("uuid", uuidCode);
        ctx.setResponseBody(jsonObject.toString());
        LOGGER.error("uuid error is: " + uuidCode);
    }
}