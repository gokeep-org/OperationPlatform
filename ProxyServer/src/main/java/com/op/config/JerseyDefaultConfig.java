package com.op.config;

import com.op.bean.Endpoint;
import com.op.bean.ReverseEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/10.
 ****************************************/
@Component
public class JerseyDefaultConfig extends ResourceConfig {
    public JerseyDefaultConfig(){
        register(Endpoint.class);
        register(ReverseEndpoint.class);
    }
}
