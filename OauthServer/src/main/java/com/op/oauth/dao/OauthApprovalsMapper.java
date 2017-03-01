package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.OauthApprovals;
@Mapper
public interface OauthApprovalsMapper {
    @Insert({
        "insert into oauth_approvals (userId, clientId, ",
        "scope, status, expiresAt, ",
        "lastModifiedAt)",
        "values (#{userid,jdbcType=VARCHAR}, #{clientid,jdbcType=VARCHAR}, ",
        "#{scope,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, #{expiresat,jdbcType=TIMESTAMP}, ",
        "#{lastmodifiedat,jdbcType=TIMESTAMP})"
    })
    int insert(OauthApprovals record);

    @Select({
        "select",
        "userId, clientId, scope, status, expiresAt, lastModifiedAt",
        "from oauth_approvals"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="clientId", property="clientid", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="expiresAt", property="expiresat", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastModifiedAt", property="lastmodifiedat", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OauthApprovals> selectAll();
}