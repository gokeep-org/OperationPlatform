package com.op.oauth.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.op.oauth.bean.OauthClientDetails;

public class OauthClientDetailsSqlProvider {

    public String insertSelective(OauthClientDetails record) {
        BEGIN();
        INSERT_INTO("oauth_client_details");
        
        if (record.getClientId() != null) {
            VALUES("client_id", "#{clientId,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceIds() != null) {
            VALUES("resource_ids", "#{resourceIds,jdbcType=VARCHAR}");
        }
        
        if (record.getClientSecret() != null) {
            VALUES("client_secret", "#{clientSecret,jdbcType=VARCHAR}");
        }
        
        if (record.getScope() != null) {
            VALUES("scope", "#{scope,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorizedGrantTypes() != null) {
            VALUES("authorized_grant_types", "#{authorizedGrantTypes,jdbcType=VARCHAR}");
        }
        
        if (record.getWebServerRedirectUri() != null) {
            VALUES("web_server_redirect_uri", "#{webServerRedirectUri,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorities() != null) {
            VALUES("authorities", "#{authorities,jdbcType=VARCHAR}");
        }
        
        if (record.getAccessTokenValidity() != null) {
            VALUES("access_token_validity", "#{accessTokenValidity,jdbcType=INTEGER}");
        }
        
        if (record.getRefreshTokenValidity() != null) {
            VALUES("refresh_token_validity", "#{refreshTokenValidity,jdbcType=INTEGER}");
        }
        
        if (record.getAdditionalInformation() != null) {
            VALUES("additional_information", "#{additionalInformation,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoapprove() != null) {
            VALUES("autoapprove", "#{autoapprove,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OauthClientDetails record) {
        BEGIN();
        UPDATE("oauth_client_details");
        
        if (record.getResourceIds() != null) {
            SET("resource_ids = #{resourceIds,jdbcType=VARCHAR}");
        }
        
        if (record.getClientSecret() != null) {
            SET("client_secret = #{clientSecret,jdbcType=VARCHAR}");
        }
        
        if (record.getScope() != null) {
            SET("scope = #{scope,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorizedGrantTypes() != null) {
            SET("authorized_grant_types = #{authorizedGrantTypes,jdbcType=VARCHAR}");
        }
        
        if (record.getWebServerRedirectUri() != null) {
            SET("web_server_redirect_uri = #{webServerRedirectUri,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorities() != null) {
            SET("authorities = #{authorities,jdbcType=VARCHAR}");
        }
        
        if (record.getAccessTokenValidity() != null) {
            SET("access_token_validity = #{accessTokenValidity,jdbcType=INTEGER}");
        }
        
        if (record.getRefreshTokenValidity() != null) {
            SET("refresh_token_validity = #{refreshTokenValidity,jdbcType=INTEGER}");
        }
        
        if (record.getAdditionalInformation() != null) {
            SET("additional_information = #{additionalInformation,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoapprove() != null) {
            SET("autoapprove = #{autoapprove,jdbcType=VARCHAR}");
        }
        
        WHERE("client_id = #{clientId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}