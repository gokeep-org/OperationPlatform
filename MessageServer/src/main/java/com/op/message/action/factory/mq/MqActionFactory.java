package com.op.message.action.factory.mq;

import java.util.Map;

import com.op.message.action.factory.BaseActionFactory;
import com.op.message.action.mq.PushMessageToElasticsearchAction;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
public class MqActionFactory extends BaseActionFactory {
    public static PushMessageToElasticsearchAction getPushMessageToElasticsearchAction(Map<String, Object> message) {
        return new PushMessageToElasticsearchAction(message);
    }
}