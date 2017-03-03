package com.op.oauth.service;

import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface ClientService<T, S, U> {
    S createClient(T t);

    S deleteClient(String clientId);

    S updateClient(T t);

    T getClientByClientId(String clientId);

    List<T> getClientByUserId(String userId);

    List<T> getAllClient();

    S freezeClientByClientId(String clientId);
}