package com.op.proxy.util;

import com.netflix.zuul.context.RequestContext;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/23.
 ****************************************/
public interface Filter {
    public void process(RequestContext requestContext);
}
