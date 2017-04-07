package com.op.proxy.filter;

import com.google.gson.JsonObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/7.
 ****************************************/
@Configuration
public class RouteErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(500);
        JsonObject routeError = new JsonObject();
        routeError.addProperty("code", 500);
        routeError.addProperty("msg", "proxy server error, path: " + ctx.getRequest().getRequestURL().toString());
        routeError.addProperty("uuid", UUID.randomUUID().toString());
        return null;
    }
}
