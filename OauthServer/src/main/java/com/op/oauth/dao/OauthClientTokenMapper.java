package com.op.oauth.dao;

import com.op.oauth.bean.OauthClientToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface OauthClientTokenMapper {
    @Insert({
        "insert into oauth_client_token (token_id, authentication_id, ",
        "user_name, client_id, ",
        "token)",
        "values (#{tokenId,jdbcType=VARCHAR}, #{authenticationId,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{clientId,jdbcType=VARCHAR}, ",
        "#{token,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthClientToken record);

    @InsertProvider(type=OauthClientTokenSqlProvider.class, method="insertSelective")
    int insertSelective(OauthClientToken record);
}