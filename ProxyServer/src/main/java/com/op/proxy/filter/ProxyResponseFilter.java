//package com.op.proxy.filter;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import com.netflix.zuul.ZuulFilter;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/11.
// ****************************************/
//@Configuration
//public class ProxyResponseFilter  extends ZuulFilter {
//    @Autowired
//    private HttpServletResponse httpServletResponse;
//    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyRequestFilter.class);
//    @Override
//    public String filterType() {
//        return "post";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 2;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//
//    /**
//     * 通过网关之前需要进行权限校验
//     * @return
//     */
//    @Override
//    public Object run() {
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        return null;
//    }
//
//    public HttpServletResponse getHttpServletResponse() {
//        return httpServletResponse;
//    }
//
//    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
//        this.httpServletResponse = httpServletResponse;
//    }
//}
