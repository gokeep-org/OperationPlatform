package com.op.oauth.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.op.oauth.bean.OauthRefreshToken;

public class OauthRefreshTokenSqlProvider {

    public String insertSelective(OauthRefreshToken record) {
        BEGIN();
        INSERT_INTO("oauth_refresh_token");
        
        if (record.getTokenId() != null) {
            VALUES("token_id", "#{tokenId,jdbcType=VARCHAR}");
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