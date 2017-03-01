package com.op.oauth.dao;

import com.op.oauth.bean.OauthAccessTokenWithBLOBs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface OauthAccessTokenMapper {
    @Insert({
        "insert into oauth_access_token (token_id, authentication_id, ",
        "user_name, client_id, ",
        "refresh_token, token, ",
        "authentication)",
        "values (#{tokenId,jdbcType=VARCHAR}, #{authenticationId,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{clientId,jdbcType=VARCHAR}, ",
        "#{refreshToken,jdbcType=VARCHAR}, #{token,jdbcType=LONGVARBINARY}, ",
        "#{authentication,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthAccessTokenWithBLOBs record);

    @InsertProvider(type=OauthAccessTokenSqlProvider.class, method="insertSelective")
    int insertSelective(OauthAccessTokenWithBLOBs record);
}