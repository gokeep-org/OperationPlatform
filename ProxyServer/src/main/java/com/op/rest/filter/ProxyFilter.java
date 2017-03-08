package com.op.rest.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

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
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info(String.format("proxy filter " + "%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        String accessToken = request.getHeader("access_token");
        String userId = request.getHeader("user_id");
        LOGGER.info("proxy filte " + "get user_id :" + userId + " access_token is:" + accessToken);
        
        return null;
    }
}
