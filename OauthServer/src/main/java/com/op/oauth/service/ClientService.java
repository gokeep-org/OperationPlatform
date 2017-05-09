package com.op.oauth.service;

import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface ClientService<T, S, U> {
    /**
     * 创建客户端
     * @param t
     * @return
     */
    S createClient(T t);

    /**
     * 删除客户端
     * @param clientId
     * @return
     */
    S deleteClient(String clientId);

    /**
     * 更新客户端信息
     * @param t
     * @return
     */
    S updateClient(T t);

    /**
     * 根据ID获取客户端信息
     * @param clientId
     * @return
     */
    T getClientByClientId(String clientId);

    List<T> getClientByUserId(String userId);

    List<T> getAllClient();

    S freezeClientByClientId(String clientId);
}