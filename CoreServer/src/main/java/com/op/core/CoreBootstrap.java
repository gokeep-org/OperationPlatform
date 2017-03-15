package com.op.core;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CoreBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CoreBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

    }
}