package com.op.proxy.filter;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import com.google.gson.JsonObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.op.proxy.config.OperationPlatformException;
import com.op.proxy.service.CommonService;
import com.op.proxy.service.AuthService;
import com.op.util.bean.log.MessageLog;

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
    @Autowired
    private CommonService commonService;

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
        LOGGER.info("Proxy server request filter start");
        RequestContext ctx = RequestContext.getCurrentContext();
        String accessToken = ctx.getRequest().getHeader("access_token");
        String userId = ctx.getRequest().getHeader("user_id");
        String path = ctx.getRequest().getRequestURI();
        String method = ctx.getRequest().getMethod();
        if (!authService.checkAccessAuth(userId, path, method.toUpperCase())) {
            buildAccessAuthErrorInfoToRequestComtext(ctx);
            throw new OperationPlatformException("user don't access power");
        }
        // 验证Token
//        pushRequestMessage(userId, path, method, null);
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

    public void buildAccessAuthErrorInfoToRequestComtext(RequestContext ctx) {
        ctx.setResponseStatusCode(500);
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=utf-8");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("msg", "当前用户没有访问权限");
        jsonObject.addProperty("code", 500);
        jsonObject.addProperty("success", false);
        String uuidCode = UUID.randomUUID().toString();
        jsonObject.addProperty("uuid", uuidCode);
        ctx.setResponseBody(jsonObject.toString());
        LOGGER.error("uuid error is: " + uuidCode);
    }

    @Async
    public void pushRequestMessage(String userId, String path, String method, Map<String, Object> params) {
        MessageLog log = new MessageLog();
        log.setRequestLog(userId, path, method, params);
//        commonService.pushLogMessage(log);
    }
}