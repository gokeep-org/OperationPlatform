package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.OauthClientToken;
@Mapper
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

    @Select({
        "select",
        "token_id, authentication_id, user_name, client_id, token",
        "from oauth_client_token"
    })
    @Results({
        @Result(column="token_id", property="tokenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="authentication_id", property="authenticationId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_id", property="clientId", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<OauthClientToken> selectAll();
}