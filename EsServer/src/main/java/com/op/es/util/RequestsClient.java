package com.op.es.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import requests.core.RequestImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
@Component
public class RequestsClient {
    @Bean
    public requests.Requests setRequests(){
        return new RequestImpl();
    }
}
