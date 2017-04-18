package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.entity.Token;

@Mapper
public interface TokenMapper {
    @Delete({
            "delete from token",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into token (token_id, ",
            "access_token, refresh_token, ",
            "exprise_in, client_id, ",
            "create_date, user_id)",
            "values (#{tokenId,jdbcType=VARCHAR}, ",
            "#{accessToken,jdbcType=VARCHAR}, #{refreshToken,jdbcType=VARCHAR}, ",
            "#{expriseIn,jdbcType=BIGINT}, #{clientId,jdbcType=VARCHAR}, ",
            "#{createDate,jdbcType=TIMESTAMP}, #{userId,jdbcType=VARCHAR})"
    })
    int insert(Token record);

    @Select({
            "select",
            "token_id, access_token, refresh_token, exprise_in, client_id, create_date,",
            "user_id",
            "from token",
            "where token_id = #{tokenId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "token_id", property = "tokenId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exprise_in", property = "expriseIn", jdbcType = JdbcType.BIGINT),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR)
    })
    Token selectByTokenId(String tokenId);

    @Select({
            "select",
            "token_id, access_token, refresh_token, exprise_in, client_id, create_date,",
            "user_id",
            "from token",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "token_id", property = "tokenId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exprise_in", property = "expriseIn", jdbcType = JdbcType.BIGINT),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR)
    })
    List<Token> selectByUserId(String userId);

    @Select({
            "select",
            "id, token_id, access_token, refresh_token, exprise_in, client_id, create_date, ",
            "user_id",
            "from token"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "token_id", property = "tokenId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exprise_in", property = "expriseIn", jdbcType = JdbcType.BIGINT),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR)
    })
    List<Token> selectAll();

    @Update({
            "update token",
            "access_token = #{accessToken,jdbcType=VARCHAR},",
            "refresh_token = #{refreshToken,jdbcType=VARCHAR},",
            "exprise_in = #{expriseIn,jdbcType=BIGINT},",
            "client_id = #{clientId,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP},",
            "user_id = #{userId,jdbcType=VARCHAR}",
            "where token_id = #{tokenId,jdbcType=VARCHAR}"
    })
    int updateByTokenId(Token token);

    @Update({
            "update token",
            " set create_date = #{createDate,jdbcType=TIMESTAMP} ",
            "where token_id = #{tokenId,jdbcType=VARCHAR}"
    })
    int updateCreateByTokenId(Token token);

    @Update({
            "update token",
            " set create_date = #{createDate,jdbcType=TIMESTAMP},",
            "access_token = #{accessToken,jdbcType=VARCHAR} ",
            "where token_id = #{tokenId,jdbcType=VARCHAR}"
    })
    int refreshTokenByTokenId(Token token);

    @Update({
            "update token",
            " set create_date = #{createDate,jdbcType=TIMESTAMP},",
            "access_token = #{accessToken,jdbcType=VARCHAR} ",
            "where token_id = #{tokenId,jdbcType=VARCHAR}"
    })
    int refreshTokenByRefreshToken(Token token);


    @Select({
            "select",
            "token_id, access_token, refresh_token, exprise_in, client_id, create_date,",
            "user_id",
            "from token",
            "where access_token = #{accessToken,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "token_id", property = "tokenId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "refresh_token", property = "refreshToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exprise_in", property = "expriseIn", jdbcType = JdbcType.BIGINT),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR)
    })
    List<Token> checkToken(String accessToken);
}