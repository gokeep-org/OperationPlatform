package com.op.proxy.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import requests.Requests;
import requests.core.RequestImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/13.
 ****************************************/
@Configuration
public class RequestsConfig {
    @Bean
    Requests requests(){
        return new RequestImpl();
    }
}
