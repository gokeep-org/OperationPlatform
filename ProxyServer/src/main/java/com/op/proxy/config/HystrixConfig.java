package com.op.proxy.config;

import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/7.
 ****************************************/
@Configuration
public class HystrixConfig extends HystrixCommand {
    protected HystrixConfig(HystrixCommandGroupKey group) {
        super(group);
    }

    protected HystrixConfig(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool) {
        super(group, threadPool);
    }

    protected HystrixConfig(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected HystrixConfig(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, threadPool, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected HystrixConfig(Setter setter) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(60))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(8000))
        );
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
