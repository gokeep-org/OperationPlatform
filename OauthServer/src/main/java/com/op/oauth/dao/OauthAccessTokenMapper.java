package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.OauthAccessToken;
@Mapper
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
    int insert(OauthAccessToken record);

    @Select({
        "select",
        "token_id, authentication_id, user_name, client_id, refresh_token, token, authentication",
        "from oauth_access_token"
    })
    @Results({
        @Result(column="token_id", property="tokenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="authentication_id", property="authenticationId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_id", property="clientId", jdbcType=JdbcType.VARCHAR),
        @Result(column="refresh_token", property="refreshToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="authentication", property="authentication", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<OauthAccessToken> selectAll();
}