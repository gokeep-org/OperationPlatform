package com.op.oauth.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/22.
 ****************************************/
//@Configuration
//public class DataSourceConfig {
//	@Bean(name="primaryDataSource")
//	@Primary
//	@ConfigurationProperties(prefix="datasource")
//	public DataSource primaryDataSource() {
//		System.out.println("-------------------- primaryDataSource init ---------------------");
//		return DataSourceBuilder.create().build();
//
//	}
//}
