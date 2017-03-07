package com.op;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProxyBootstrap
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(ProxyBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}