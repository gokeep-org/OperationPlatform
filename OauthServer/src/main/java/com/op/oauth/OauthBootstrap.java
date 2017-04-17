package com.op.oauth;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/22.
 ****************************************/
@SpringBootApplication
@EnableDiscoveryClient
@ImportResource(value = {"classpath:spring.xml"})
public class OauthBootstrap {
	public static void main(String[] args) {
        new SpringApplicationBuilder(OauthBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
    
}