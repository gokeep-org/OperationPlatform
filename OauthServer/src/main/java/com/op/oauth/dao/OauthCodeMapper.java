package com.op.oauth.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

import com.op.oauth.bean.OauthCode;

@Mapper
public interface OauthCodeMapper {
    @Insert({
        "insert into oauth_code (code, authentication)",
        "values (#{code,jdbcType=VARCHAR}, #{authentication,jdbcType=LONGVARBINARY})"
    })
    int insert(OauthCode record);

    @InsertProvider(type=OauthCodeSqlProvider.class, method="insertSelective")
    int insertSelective(OauthCode record);
}