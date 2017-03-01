package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.OauthRefreshToken;
@Mapper
public interface OauthRefreshTokenMapper {
    @Insert({
        "insert into oauth_refresh_token (token_id, token, ",
        "authentication)",
        "values (#{tokenId,jdbcType=VARCHAR}, #{token,jdbcType=LONGVARBINARY}, ",
        "#{authentication,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthRefreshToken record);

    @Select({
        "select",
        "token_id, token, authentication",
        "from oauth_refresh_token"
    })
    @Results({
        @Result(column="token_id", property="tokenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="authentication", property="authentication", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<OauthRefreshToken> selectAll();
}