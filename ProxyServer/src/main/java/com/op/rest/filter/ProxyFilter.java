package com.op.rest.filter;

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
//        String accessToken = request.getParameter("access_token");
//        String userId = request.getParameter("user_id");
//        LOGGER.info("proxy filte " + "get user_id :" + userId + " access_token is:" + accessToken);
//////        if (null == accessToken || null == userId) {
//////            LOGGER.warn("proxy filte found user_id or access_token is null");
//            ctx.setSendZuulResponse(true);
//        try {
//            ctx.setRouteHost(new URL("localhost"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        ;
//////            ctx.setResponseStatusCod
// e(203);
//////            return null;
//////        }
//////        return null;
        return null;
    }
}
