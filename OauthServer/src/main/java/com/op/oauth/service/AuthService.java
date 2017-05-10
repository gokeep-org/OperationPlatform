package com.op.oauth.service;

import com.google.gson.JsonObject;
import com.op.oauth.bean.entity.Event;
import com.op.oauth.bean.entity.Rule;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface AuthService<T, C> {
    T authorization(C c);

    /**
     * 创建用户访问规则
     * @param path
     * @param method
     * @param userId
     * @return
     */
    public Boolean checkUserAccessAuth(String path, String method, String userId);

    /**
     * 创新Rule
     * @param rule
     * @return
     */
    public Boolean createRule(Rule rule);

    /**
     * 创建事件规则
     * @param event
     * @return
     */
    public Boolean createEvent(Event event);

    /**
     * 根据Id查询Event
     * @param id
     * @return
     */
    public JsonObject getRuleById(String id);
}