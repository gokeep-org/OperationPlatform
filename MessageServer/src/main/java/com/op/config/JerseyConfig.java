package com.op.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        setJerseyComponentsLocation();
    }
    private void setJerseyComponentsLocation() {
        packages("com.op.rest");
    }

}