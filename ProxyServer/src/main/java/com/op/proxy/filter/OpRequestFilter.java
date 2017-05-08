/*
 * Copyright (c) 2010-2015 EEFUNG Software Co.Ltd. All rights reserved. 版权所有(c)2010-2015湖南蚁坊软件有限公司。保留所有权利。
 */
package com.op.proxy.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    public void filter(ContainerRequestContext requestContext) throws IOException {
        // 请求基本信息记录日志信息
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        String accessToken = requestContext.getHeaderString("token");
        String userId = requestContext.getHeaderString("user_id");
        LOGGER.info(
                "request params: [path: "
                        + path + "],[method: "
                        + method + "],[user_id: "
                        + userId + "],[access_token: "
                        + accessToken + "]");
    }
}
