package com.op.oauth.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.op.oauth.bean.OauthApprovals;

public class OauthApprovalsSqlProvider {

    public String insertSelective(OauthApprovals record) {
        BEGIN();
        INSERT_INTO("oauth_approvals");
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=VARCHAR}");
        }
        
        if (record.getClientid() != null) {
            VALUES("clientId", "#{clientid,jdbcType=VARCHAR}");
        }
        
        if (record.getScope() != null) {
            VALUES("scope", "#{scope,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getExpiresat() != null) {
            VALUES("expiresAt", "#{expiresat,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastmodifiedat() != null) {
            VALUES("lastModifiedAt", "#{lastmodifiedat,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }
}