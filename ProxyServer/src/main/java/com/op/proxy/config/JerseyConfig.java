package com.op.proxy.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.context.annotation.Configuration;

import com.op.proxy.filter.OpRequestFilter;
import com.op.proxy.filter.OpResponseFilter;
import com.op.proxy.provide.GsonMessageBodyHandler;
import com.op.util.bean.BasePath;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Configuration
@ApplicationPath(BasePath.PROXY)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        setJerseyComponentsLocation();
        registerJerseyFilter();
        registerJsonProvider();
        registerCompressionEncoder();
        registerSwagger();
    }

    private void setJerseyComponentsLocation() {
        packages("com.op.proxy.rest");
    }

    private void registerJerseyFilter() {
        register(OpRequestFilter.class);
        register(OpResponseFilter.class);
    }

    private void registerJsonProvider() {
        register(GsonMessageBodyHandler.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, false);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    }

    /**
     * 注册Response body压缩时用到的encoder
     */
    private void registerCompressionEncoder() {
        registerClasses(EncodingFilter.class, GZipEncoder.class, DeflateEncoder.class);
    }

    /**
     * 注册Swagger,用于生成api文档
     */
    private void registerSwagger() {
    }
}