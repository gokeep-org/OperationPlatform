package com.op.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/

@EnableEurekaServer
@SpringBootApplication
public class EurekaBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}