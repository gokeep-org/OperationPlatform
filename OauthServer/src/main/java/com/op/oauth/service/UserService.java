package com.op.oauth.service;

import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface UserService<T, S> {

    /**
     * 创建用户
     * @param t
     * @return
     */
    S createUser(T t);

    /**
     * 跟新用户信息
     * @param t
     * @return
     */
    S updateUser(T t);

    /**
     * 删除用户
     * @param t
     * @return
     */
    S deleteUser(T t);

    /**
     * 销毁用户
     * @param userId
     * @return
     */
    S freezeUser(String userId);

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    T getUserById(String userId);

    /**
     * 根据Token获取用户信息
     * @param accessToken
     * @return
     */
    T getUserByToken(String accessToken);

    /**
     * 获取所有的用户
     * @return
     */
    List<T> getAllUser();

    /**
     * 验证是否存在当前用户
     * @param t
     * @return
     */
    S checkoutUserNameIsExist(T t);

    /**
     * 验证用户的登录状态
     * @param t
     * @return
     */
    List<T> checkUserIsLogin(T t);
}
