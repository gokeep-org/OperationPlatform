package com.op.oauth.service.impl;

import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Token;
import com.op.oauth.bean.entity.User;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.service.TokenService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.TOKEN_SERVICE)
public class TokenServiceImpl extends BaseService implements TokenService<Token, Boolean, User> {
    @Override
    public Token createToken(String clientId) {
        return null;
    }

    @Override
    public Token getTokenByUserLogin(User user) {
        return null;
    }

    @Override
    public Token getTokenByAuthCode(String autoCode) {
        return null;
    }

    @Override
    public Token refreshTokenByRefreshToken(String refreshToken) {
        return null;
    }

    @Override
    public Boolean checkToken(Token token) {
        return null;
    }

    @Override
    public Boolean deleteToken(Token token) {
        return null;
    }

    @Override
    public Boolean freezeToken(Token token) {
        return null;
    }
}
