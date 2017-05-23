/*
 * Copyright (c) 2010-2015 EEFUNG Software Co.Ltd. All rights reserved. 版权所有(c)2010-2015湖南蚁坊软件有限公司。保留所有权利。
 */
package com.op.oauth.action.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>request和response过滤器。<p>
 * <p>
 * 创建日期 2016年1月11日<br>
 * @author zhengpengfei<br>
 * @version $Revision$ $Date$
 * @since 1.0.0
 */
@Provider
public class OpRequestFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpRequestFilter.class);
    @Autowired
    private HttpServletRequest httpServletRequest;
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
//        Map<String, Cookie> s=requestContext.getCookies();
        String userId = requestContext.getHeaderString("user_id");
        String accessToken = requestContext.getHeaderString("access_token");
        String filterInfo = "request params: [path: %s], [method:  %s], [user_id: %s], [access_token: %s]";
        LOGGER.info(String.format(filterInfo, path, method, userId, accessToken));
    }
}