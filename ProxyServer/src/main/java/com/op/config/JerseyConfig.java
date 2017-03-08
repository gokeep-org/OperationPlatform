package com.op.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.context.annotation.Configuration;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Configuration
@ApplicationPath("/proxy")
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

	private void registerJerseyFilter() {

	}

	private void registerJsonProvider() {

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