package com.op.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/21.
 ****************************************/
@EnableDiscoveryClient
@SpringBootApplication
@EnableAdminServer
public class AdminServerBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminServerBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
