package com.op.oauth.dao.mybatis;

import com.op.oauth.bean.entity.OauthApprovals;

public interface OauthApprovalsMapper {
    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);
}