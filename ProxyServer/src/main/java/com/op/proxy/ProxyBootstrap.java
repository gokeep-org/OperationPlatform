package com.op.proxy;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringCloudApplication
@EnableZuulProxy
@ImportResource(value = {"classpath:spring.xml"})
public class ProxyBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProxyBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}