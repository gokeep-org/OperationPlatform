package com.op.oauth.dao.mybatis;

import com.op.oauth.bean.entity.OauthRefreshToken;

public interface OauthRefreshTokenMapper {
    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);
}