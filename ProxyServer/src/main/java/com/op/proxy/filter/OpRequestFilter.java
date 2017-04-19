/*
 * Copyright (c) 2010-2015 EEFUNG Software Co.Ltd. All rights reserved. 版权所有(c)2010-2015湖南蚁坊软件有限公司。保留所有权利。
 */
package com.op.proxy.filter;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import com.netflix.zuul.context.RequestContext;
import com.op.util.requests.Requests;


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
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private Requests requests;

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
        RequestContext ctx = RequestContext.getCurrentContext();
//        //TODO: 这里要对token和user_id进行校验,请求Oauth2
//        String a = loadBalancerClient.choose(ServerName.OAUTH).getHost();
//        int b = loadBalancerClient.choose(ServerName.OAUTH).getPort();
//        String c = loadBalancerClient.choose(ServerName.OAUTH).getServiceId();
//        String url = loadBalancerClient.choose(ServerName.OAUTH).getUri()+"/token/check";
//        Map<String, String> params = new HashMap<>();
//        params.put("access_token", accessToken);
//        params.put("user_id", userId);
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        String res = requests.get(url, params, headers).json();
//        JsonObject r = new Gson().fromJson(res, JsonObject.class);
//        String success = r.get("success").getAsString();
//        if (!r.get("success").getAsString().equals("true")){
//            ctx.setResponseStatusCode(500);
//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("msg", "token为空或者过期");
//            jsonObject.addProperty("code", 500);
//            jsonObject.addProperty("success", false);
//            jsonObject.addProperty("uuid", UUID.randomUUID().toString());
//            ctx.setResponseBody(jsonObject.toString());
//            throw new OperationPlatformException("token is invoid or null");
//        }
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
