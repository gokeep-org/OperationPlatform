package com.op.oauth.dao;

import com.op.oauth.bean.OauthApprovals;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface OauthApprovalsMapper {
    @Insert({
        "insert into oauth_approvals (userId, clientId, ",
        "scope, status, expiresAt, ",
        "lastModifiedAt)",
        "values (#{userid,jdbcType=VARCHAR}, #{clientid,jdbcType=VARCHAR}, ",
        "#{scope,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, #{expiresat,jdbcType=TIMESTAMP}, ",
        "#{lastmodifiedat,jdbcType=TIMESTAMP})"
    })
    int insert(OauthApprovals record);

    @InsertProvider(type=OauthApprovalsSqlProvider.class, method="insertSelective")
    int insertSelective(OauthApprovals record);
}