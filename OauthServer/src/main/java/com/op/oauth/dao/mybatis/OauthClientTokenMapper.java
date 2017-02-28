package com.op.oauth.dao.mybatis;

import com.op.oauth.bean.entity.OauthClientToken;

public interface OauthClientTokenMapper {
    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);
}