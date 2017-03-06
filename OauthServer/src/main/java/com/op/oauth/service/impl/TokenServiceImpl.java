package com.op.oauth.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Token;
import com.op.oauth.bean.entity.User;
import com.op.oauth.config.OpCommonConfig;
import com.op.oauth.dao.TokenMapper;
import com.op.oauth.exception.ErrorCode;
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
        List<Token> tokens = tokenMapper.selectByUserId(userId);
        if (OpUtils.checkObjectIsNull(tokens) || tokens.size() <= 0) {
            Token token = new Token();
            String tokenId = UUID.randomUUID().toString();
            token.setTokenId(tokenId);
            token.setAccessToken(UUID.randomUUID().toString());
            token.setRefreshToken(UUID.randomUUID().toString());
            token.setClientId(null);
            token.setCreateDate(new Date());
            token.setExpriseIn(OpCommonConfig.TOKEN_EXPRISE_TIME);
            token.setUserId(userId);
            int res = tokenMapper.insert(token);
            if (OpUtils.checkMapperCudIsSuccess(res)) {
                return tokenMapper.selectByTokenId(tokenId);
            } else {
                throw new OperationPlatformException("get token info error");
            }
        }
        List<Token> oldTokens = tokens.stream().filter(e -> {
            return ((new Date().getTime() - e.getCreateDate().getTime()) < e.getExpriseIn() * 1000);
        }).collect(Collectors.toList());
        if (OpUtils.checkObjectIsNull(oldTokens)) {
            //是否刷新token
            List<Token> needRefreshToken = tokens.stream().filter(e -> {
                return ((new Date().getTime() - e.getCreateDate().getTime()) > e.getExpriseIn() * 1000);
            }).collect(Collectors.toList());
            if (OpUtils.checkObjectIsNull(needRefreshToken)) {
                throw new OperationPlatformException("获取旧的token为空");
            }
            Token refreshToken = needRefreshToken.get(0);
            refreshToken.setCreateDate(new Date());
            refreshToken.setAccessToken(UUID.randomUUID().toString());
            if (OpUtils.checkMapperCudIsSuccess(tokenMapper.refreshTokenByTokenId(refreshToken))) {
                return tokenMapper.selectByTokenId(refreshToken.getTokenId());
            }
        }
        Token updToken = oldTokens.get(0);
        updToken.setCreateDate(new Date());
        if (!OpUtils.checkMapperCudIsSuccess(tokenMapper.updateCreateByTokenId(updToken))) {
            throw new OperationPlatformException("更新已有token出现异常");
        }
        return tokenMapper.selectByTokenId(updToken.getTokenId());
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
        if (OpUtils.checkStringIsNull(refreshToken)) {
            throw new OperationPlatformException("refresh token refresh token is null");
        }
        return null;
    }

    @Override
    public List<Token> checkToken(Token token) {
        List<Token> tokens = tokenMapper.checkToken(token.getAccessToken());
        List<Token> validToken = tokens.stream().filter(e -> {
            if (e.getUserId().equals(token.getUserId())) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        if ((new Date().getTime() - validToken.get(0).getCreateDate().getTime())>validToken.get(0).getExpriseIn()*OpCommonConfig.TOKEN_EXPRISE_TIME){
            Token refreshToken =createTokenByUserId(token.getUserId());
            tokens.set(0, refreshToken);
        }
        if (OpUtils.checkObjectIsNull(tokens)) {
            throw new OperationPlatformException(ErrorCode.CHECK_ACCESS_TOKEN_FAILED);
        }
        return tokens;
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
