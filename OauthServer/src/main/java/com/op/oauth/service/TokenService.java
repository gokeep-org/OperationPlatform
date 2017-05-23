package com.op.oauth.service;

import java.util.List;

import com.op.oauth.bean.entity.Token;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface TokenService<T, S, U> {
    /**
     * 根据客户端ID创建Token
     * @param clientId
     * @return
     */
    T createTokenByClientId(String clientId);

    /**
     * 根据用户ID创建Token
     * @param userId
     * @return
     */
    T createTokenByUserId(String userId);

    /**
     * 根据用户登录状态获取Token
     * @param u
     * @return
     */
    T getTokenByUserLogin(U u);

    /**
     * 根据授权码获取客户端
     * @param autoCode
     * @return
     */
    T getTokenByAuthCode(String autoCode);

    /**
     * 根据RefreshToken刷新Token信息
     * @param refreshToken
     * @return
     */
    T refreshTokenByRefreshToken(String refreshToken);

    /**
     * 验证Token信息
     * @param t
     * @return
     */
    List<T> checkToken(T t);

    /**
     * 删除Token信息
     * @param t
     * @return
     */
    S deleteToken(T t);

    /**
     * 销毁Token
     * @param t
     * @return
     */
    S freezeToken(T t);

    void setCookie(Token token);

}