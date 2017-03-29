package com.op.core.action.item;


import com.op.core.action.BaseAction;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.service.BaseService;
import com.op.core.service.ReadServices;
import com.op.core.service.ServiceBeanNames;
import com.op.core.service.WriteService;
import com.op.core.service.impl.ReadServiceImpl;
import com.op.core.service.impl.WriteServiceImpl;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static ReadServices readServices = BaseService.getService(
            ServiceBeanNames.READ_SERVICE, ReadServiceImpl.class
    );

    public static WriteService writeService = BaseService.getService(
            ServiceBeanNames.WRITE_SERVICE, WriteServiceImpl.class
    );
}