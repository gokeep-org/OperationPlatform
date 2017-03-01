package com.op.oauth.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.op.oauth.bean.OauthAccessTokenWithBLOBs;

public class OauthAccessTokenSqlProvider {

    public String insertSelective(OauthAccessTokenWithBLOBs record) {
        BEGIN();
        INSERT_INTO("oauth_access_token");
        
        if (record.getTokenId() != null) {
            VALUES("token_id", "#{tokenId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthenticationId() != null) {
            VALUES("authentication_id", "#{authenticationId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getClientId() != null) {
            VALUES("client_id", "#{clientId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefreshToken() != null) {
            VALUES("refresh_token", "#{refreshToken,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            VALUES("token", "#{token,jdbcType=LONGVARBINARY}");
        }
        
        if (record.getAuthentication() != null) {
            VALUES("authentication", "#{authentication,jdbcType=LONGVARBINARY}");
        }
        
        return SQL();
    }
}