package com.op.oauth.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.op.oauth.bean.OauthCode;

public class OauthCodeSqlProvider {

    public String insertSelective(OauthCode record) {
        BEGIN();
        INSERT_INTO("oauth_code");
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthentication() != null) {
            VALUES("authentication", "#{authentication,jdbcType=LONGVARBINARY}");
        }
        
        return SQL();
    }
}