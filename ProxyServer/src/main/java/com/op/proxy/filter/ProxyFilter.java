package com.op.proxy.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/8.
 ****************************************/

public class ProxyFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyFilter.class);

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
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("***************Proxy Filter**************************");
        LOGGER.info("请求url: "+request.getRequestURL());
        LOGGER.info("请求方法： "+request.getMethod());
        String accessToken = request.getHeader("access_token");
        String userId = request.getHeader("user_id");
        LOGGER.info("proxy filter " + "get user_id :" + userId + " access_token is:" + accessToken);
        LOGGER.info("******************************************************");

        //TODO: 这里要对token和user_id进行校验,请求Oauth2
        return null;
    }
}