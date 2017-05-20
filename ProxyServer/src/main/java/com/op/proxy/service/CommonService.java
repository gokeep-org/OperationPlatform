package com.op.proxy.service;

import com.op.util.bean.log.MessageLog;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
public interface CommonService {
    //推送日志消息到消息队列中
    public void pushLogMessage(MessageLog log);

}
