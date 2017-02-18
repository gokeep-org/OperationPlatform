package com.op.config;

import com.op.library.provide.GsonMessageBodyHandler;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.context.annotation.Configuration;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        setJerseyComponentsLocation();
        registerJerseyFilter();
        registerJsonProvider();
        registerCompressionEncoder();
        registerSwagger();

    }
    private void setJerseyComponentsLocation() {
        packages("com.op.rest");
    }

    private void registerJerseyFilter(){
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
        register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        //        boolean isSwaggerEnabled = true;
//        if (isSwaggerEnabled) {
//            register(io.swagger.jaxrs.listing.ApiListingResource.class);
//            register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
//            BeanConfig beanConfig = new BeanConfig();
//            beanConfig.setVersion("1.0.0");
//            beanConfig.setResourcePackage("com.op.rest");
//            beanConfig.setScan(true);
//            beanConfig.setTitle("Operation Platform");
//        }
    }
}