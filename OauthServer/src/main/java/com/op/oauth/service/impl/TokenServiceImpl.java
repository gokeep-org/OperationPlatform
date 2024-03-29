package com.op.oauth.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.op.oauth.bean.entity.Token;
import com.op.oauth.bean.entity.User;
import com.op.oauth.config.OpCommonConfig;
import com.op.oauth.dao.TokenMapper;
import com.op.oauth.exception.ErrorCode;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.service.TokenService;
import com.op.oauth.util.OpUtils;
import com.op.util.exception.OperationPlatformException;

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
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Override
    public Token createTokenByClientId(String clientId) {
        return null;
    }

    @Transactional
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
                throw new OperationPlatformException(ErrorCode.GET_TOKEN_INFO_ERROR);
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
                throw new OperationPlatformException(ErrorCode.GET_OLD_TOKEN_IS_NULL);
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
            throw new OperationPlatformException(ErrorCode.UPDATE_TOKEN_IS_ERROR);
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

    @Transactional
    @Override
    public Token refreshTokenByRefreshToken(String refreshToken) {
        if (OpUtils.checkStringIsNull(refreshToken)) {
            throw new OperationPlatformException(ErrorCode.REFRESH_TOKEN_IS_FAILED);
        }
        return null;
    }

    @Transactional
    @Override
    public List<Token> checkToken(Token token) {
        List<Token> tokens = tokenMapper.checkToken(token.getAccessToken());
        List<Token> validToken = tokens.stream().filter(e -> {
            return e.getUserId().equals(token.getUserId());
        }).collect(Collectors.toList());
        if (OpUtils.checkObjectIsNull(validToken)) {
            throw new OperationPlatformException(ErrorCode.CHECK_ACCESS_TOKEN_FAILED);
        }
        if ((new Date().getTime() - validToken.get(0).getCreateDate().getTime()) > validToken.get(0).getExpriseIn() * OpCommonConfig.TOKEN_EXPRISE_TIME) {
            Token refreshToken = createTokenByUserId(token.getUserId());
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

    @Override
    public void setCookie(Token token) {
        String userId = token.getUserId();
        String accessToken = token.getAccessToken();
        Cookie userIdCookie = new Cookie("user_id", userId);
        Cookie accessTokenCookie = new Cookie("access_token", accessToken);
        userIdCookie.setMaxAge(7200);
        accessTokenCookie.setMaxAge(7200);
        httpServletResponse.addCookie(userIdCookie);
        httpServletResponse.addCookie(accessTokenCookie);
    }

    public TokenMapper getTokenMapper() {
        return tokenMapper;
    }

    public void setTokenMapper(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }
}
