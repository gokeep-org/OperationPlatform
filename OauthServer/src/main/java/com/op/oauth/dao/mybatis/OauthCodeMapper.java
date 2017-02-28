package com.op.oauth.dao.mybatis;

import com.op.oauth.bean.entity.OauthCode;

public interface OauthCodeMapper {
    int insert(OauthCode record);

    int insertSelective(OauthCode record);
}