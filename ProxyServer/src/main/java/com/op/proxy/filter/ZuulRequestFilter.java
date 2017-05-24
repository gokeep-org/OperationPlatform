package com.op.proxy.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import com.google.gson.JsonObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.op.proxy.service.AuthService;
import com.op.proxy.service.CommonService;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

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
     * 校验的
     * @return Object
     */
    @Override
    public Object run() {
        LOGGER.info("Proxy server request filter start");
        RequestContext ctx = RequestContext.getCurrentContext();
        String userId = null;
        String accessToken = null;
        String path = ctx.getRequest().getRequestURI();
        String method = ctx.getRequest().getMethod();
//        Map<String, String> tokenMap = getCookies(ctx);
//        /**
//         * 校验是否在cookie存在授权信息
//         */
//        if (!Objects.equals(null, tokenMap) && tokenMap.size() > 0) {
//            if (null != tokenMap.get("user_id") && null != tokenMap.get("access_token")) {
//                accessToken = tokenMap.get("access_token");
//                userId = tokenMap.get("user_id");
//            }
//        }
        /**
         * 如果收授权信息依然为空，那么而就荣请求Header中拿
         */
        if (null == userId || null == accessToken) {
            accessToken = ctx.getRequest().getHeader("access_token");
            userId = ctx.getRequest().getHeader("user_id");
        }


        /**
         * 验证用户访问权限
         */
//        校验请问权限
//        if (!authService.checkAccessAuth(userId, path, method.toUpperCase())) {
//            buildAccessAuthErrorInfoToRequestComtext(ctx);
//            throw new OperationPlatformException("user don't access power");
//        }


        /**
         *推送用户请求访问日志到ElasticSearch
         * 由于未解决的问题，这里先不进行log推送
         * 问题： 消息队列发生阻塞
         */
        try {
            pushRequestMessage(userId, path, method, null);
        }catch (Throwable e){
            LOGGER.error("push request log queue is fail");
        }

        /**
         * 如果授权信息都获取不到，就抛出异常
         */
        if (null == accessToken || null == userId) {
            buildAuthErrorInfoToRequestContext(ctx);
            throw new OperationPlatformException("user_id or access_token is null");
        }

        /**
         * 验证用户认证授权信息向Oauth2服务
         */
        if (authService.checkToken(accessToken, userId)) {
            Cookie userIdCookie = new Cookie("user_id", userId);
            Cookie accessTokenCookie = new Cookie("access_token", accessToken);
            userIdCookie.setMaxAge(7200);
            accessTokenCookie.setMaxAge(7200);
            ctx.getResponse().addCookie(userIdCookie);
            ctx.getResponse().addCookie(accessTokenCookie);
            return null;
        } else {
            buildAuthErrorInfoToRequestContext(ctx);
            throw new OperationPlatformException("token is exprise in");
        }
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
        String pushMessage = String.format("zuul filter request info: [url: %s],[method: %s],[params: %s]", path, method, params);
        LOGGER.info(pushMessage);
        // 暂时不推送异步日志消息
        commonService.pushLogMessage(log);
    }

    public Map<String, String> getCookies(RequestContext requestContext) {
        Map<String, String> cookieMap = new HashMap<>();
        Cookie[] cookies = requestContext.getRequest().getCookies();
        if (Objects.equals(null, cookies) || cookies.length == 0)
            return null;
        for (Cookie cookie : cookies) {
            if (null != cookie.getName() && null != cookie.getValue()) {
                if (cookie.getName().equals("user_id")) {
                    cookieMap.put("user_id", cookie.getValue());
                }
                if (cookie.getName().equals("access_token")) {
                    cookieMap.put("access_token", cookie.getValue());
                }
            }
        }
        return cookieMap;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}