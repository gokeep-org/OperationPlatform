package com.op.proxy;

import com.op.proxy.filter.ProxyFilter;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringCloudApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ProxyBootstrap
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(ProxyBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
    
    @Bean
    public ProxyFilter proxyFilter() {
        return new ProxyFilter();
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}