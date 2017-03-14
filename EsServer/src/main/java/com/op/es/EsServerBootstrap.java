package com.op.es;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@SpringBootApplication
@EnableDiscoveryClient
public class EsServerBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EsServerBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
