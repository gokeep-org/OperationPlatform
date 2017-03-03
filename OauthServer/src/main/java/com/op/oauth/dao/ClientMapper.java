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

import com.op.oauth.bean.entity.Client;

@Mapper
public interface ClientMapper {
    @Delete({
            "delete from client",
            "where client_id = #{clientId,jdbcType=VARCHAR}"
    })
    int deleteClientByClientId(String clientId);

    @Insert({
            "insert into client (client_name, ",
            "client_id, client_secret, ",
            "state, user_id, create_date, ",
            "grant_type, code, ",
            "scope, redirect_uri)",
            "values (#{clientName,jdbcType=VARCHAR}, ",
            "#{clientId,jdbcType=VARCHAR}, #{clientSecret,jdbcType=VARCHAR}, ",
            "#{state,jdbcType=BIGINT}, #{userId,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
            "#{grantType,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
            "#{scope,jdbcType=VARCHAR}, #{redirectUri,jdbcType=VARCHAR})"
    })
    int insert(Client record);

    @Select({
            "select",
            "id, client_name, client_id, client_secret, state, user_id, create_date, grant_type, ",
            "code, scope, redirect_uri",
            "from client",
            "where client_id = #{clientId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "client_name", property = "clientName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_secret", property = "clientSecret", jdbcType = JdbcType.VARCHAR),
            @Result(column = "state", property = "state", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "grant_type", property = "grantType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
            @Result(column = "redirect_uri", property = "redirectUri", jdbcType = JdbcType.VARCHAR)
    })
    Client selectByClientId(String clientId);

    @Select({
            "select",
            "id, client_name, client_id, client_secret, state, user_id, create_date, grant_type, ",
            "code, scope, redirect_uri",
            "from client",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "client_name", property = "clientName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_secret", property = "clientSecret", jdbcType = JdbcType.VARCHAR),
            @Result(column = "state", property = "state", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "grant_type", property = "grantType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
            @Result(column = "redirect_uri", property = "redirectUri", jdbcType = JdbcType.VARCHAR)
    })
    List<Client> selectByUserId(String userId);

    @Select({
            "select",
            "id, client_name, client_id, client_secret, state, user_id, create_date, grant_type, ",
            "code, scope, redirect_uri",
            "from client"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "client_name", property = "clientName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_id", property = "clientId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "client_secret", property = "clientSecret", jdbcType = JdbcType.VARCHAR),
            @Result(column = "state", property = "state", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "grant_type", property = "grantType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scope", property = "scope", jdbcType = JdbcType.VARCHAR),
            @Result(column = "redirect_uri", property = "redirectUri", jdbcType = JdbcType.VARCHAR)
    })
    List<Client> selectAll();

    @Update({
            "update client",
            "set client_name = #{clientName,jdbcType=VARCHAR},",
            "client_secret = #{clientSecret,jdbcType=VARCHAR},",
            "state = #{state,jdbcType=BIGINT},",
            "grant_type = #{grantType,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR},",
            "scope = #{scope,jdbcType=VARCHAR},",
            "redirect_uri = #{redirectUri,jdbcType=VARCHAR}",
            "where client_id = #{clientId,jdbcType=VARCHAR}"
    })
    int updateByClientId(Client record);

    @Update({
            "update client",
            "set client_name = #{clientName,jdbcType=VARCHAR},",
            "client_secret = #{clientSecret,jdbcType=VARCHAR},",
            "state = 0,",
            "user_id = #{userId,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP},",
            "grant_type = #{grantType,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR},",
            "scope = #{scope,jdbcType=VARCHAR},",
            "redirect_uri = #{redirectUri,jdbcType=VARCHAR}",
            "where client_id = #{clientId,jdbcType=VARCHAR}"
    })
    int freezeClientByClientId(String clientId);

    @Select("select count(user_id) from client")
    int getClientCount();
}