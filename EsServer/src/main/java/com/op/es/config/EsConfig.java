package com.op.es.config;

import com.op.es.util.PropertiesUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/15.
 ****************************************/
public class EsConfig {
    public static final String esHost = PropertiesUtil.getValue("es.host");
    public static final String esPort = PropertiesUtil.getValue("es.port");
    public static final String esUri = esHost + ":" + esPort;
}
