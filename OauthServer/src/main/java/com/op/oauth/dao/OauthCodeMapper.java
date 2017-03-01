package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.OauthCode;
@Mapper
public interface OauthCodeMapper {
    @Insert({
        "insert into oauth_code (code, authentication)",
        "values (#{code,jdbcType=VARCHAR}, #{authentication,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthCode record);

    @Select({
        "select",
        "code, authentication",
        "from oauth_code"
    })
    @Results({
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="authentication", property="authentication", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<OauthCode> selectAll();
}