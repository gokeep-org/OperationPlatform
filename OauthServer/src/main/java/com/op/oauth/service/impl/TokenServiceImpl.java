package com.op.oauth.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Token;
import com.op.oauth.bean.entity.User;
import com.op.oauth.dao.TokenMapper;
import com.op.oauth.exception.OperationPlatformException;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.service.TokenService;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.TOKEN_SERVICE)
public class TokenServiceImpl extends BaseService implements TokenService<Token, Boolean, User> {
    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public Token createTokenByClientId(String clientId) {
        return null;
    }

    @Override
    public Token createTokenByUserId(String userId) {
        Token token = new Token();
        String tokenId = UUID.randomUUID().toString();
        token.setTokenId(tokenId);
        token.setAccessToken(UUID.randomUUID().toString());
        token.setRefreshToken(UUID.randomUUID().toString());
        token.setClientId(null);
        token.setCreateDate(new Date());
        token.setExpriseIn(3600L);
        token.setUserId(userId);
        int res = tokenMapper.insert(token);
        if (OpUtils.checkMapperCudIsSuccess(res)) {
            return tokenMapper.selectByTokenId(tokenId);
        }else {
            throw new OperationPlatformException("get token info error");
        }
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

    public TokenMapper getTokenMapper() {
        return tokenMapper;
    }

    public void setTokenMapper(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }
}
