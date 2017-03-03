package com.op.oauth.service;

import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface UserService<T, S> {

    S createUser(T t);

    S updateUser(T t);

    S deleteUser(T t);

    S freezeUser(String userId);

    T getUserById(String userId);

    T getUserByToken(String accessToken);

    List<T> getAllUser();

    S checkoutUserNameIsExist(T t);

    List<T> checkUserIsLogin(T t);
}
