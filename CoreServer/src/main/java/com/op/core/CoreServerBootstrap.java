package com.op.core;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
@SpringBootApplication
@EnableDiscoveryClient
public class CoreServerBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CoreServerBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
    
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}