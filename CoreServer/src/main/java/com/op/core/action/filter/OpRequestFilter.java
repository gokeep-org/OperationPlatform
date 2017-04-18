/*
 * Copyright (c) 2010-2015 EEFUNG Software Co.Ltd. All rights reserved. 版权所有(c)2010-2015湖南蚁坊软件有限公司。保留所有权利。
 */
package com.op.core.action.filter;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

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
    @Context
    private HttpServletRequest request;


    public void filter(ContainerRequestContext requestContext) throws IOException {
        getBrowerHeader(requestContext);
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        String requestPath = method + ":" + path;
        String accessToken = requestContext.getHeaderString("token");
        String userId = requestContext.getHeaderString("user_id");
        MDC.put("user_id", requestContext.getHeaderString(userId));
        MDC.put("access_token", requestContext.getHeaderString(accessToken));
        LOGGER.info("请求拦截到token is: " + accessToken);
        LOGGER.info("请求拦截到user id is: " + accessToken);
        LOGGER.info("------>>>请求路径：" + requestPath + " header " + requestContext.getHeaders());
    }

    private void getBrowerHeader(ContainerRequestContext requestContext) {
        try {
            String userAgent = request.getHeader("User-Agent");
            if (userAgent != null) {
                MDC.put("User-Agent", userAgent);
            }
            String userIp = request.getHeader("user_ip");
            if (userIp != null) {
                MDC.put("user_ip", userIp);
            } else {
                MDC.put("user_ip", getLocalAddress());
            }
        } catch (Exception e) {
        }
    }

    public static String getLocalAddress() {
        String ipStr = "127.0.0.1";
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address)
                        ipStr = ip.getHostAddress();
                }
            }
        } catch (Exception e) {
            LOGGER.error("------>>>获取本机ip失败", e);
        }
        return ipStr;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
