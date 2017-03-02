package com.op.oauth.service;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public interface TokenService<T, S, U> {
    T createToken(String clientId);

    T getTokenByUserLogin(U u);

    T getTokenByAuthCode(String autoCode);

    T refreshTokenByRefreshToken(String refreshToken);

    S checkToken(T t);

    S deleteToken(T t);

    S freezeToken(T t);

}