package com.op.oauth.dao;

import com.op.oauth.bean.OauthRefreshToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface OauthRefreshTokenMapper {
    @Insert({
        "insert into oauth_refresh_token (token_id, token, ",
        "authentication)",
        "values (#{tokenId,jdbcType=VARCHAR}, #{token,jdbcType=LONGVARBINARY}, ",
        "#{authentication,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthRefreshToken record);

    @InsertProvider(type=OauthRefreshTokenSqlProvider.class, method="insertSelective")
    int insertSelective(OauthRefreshToken record);
}