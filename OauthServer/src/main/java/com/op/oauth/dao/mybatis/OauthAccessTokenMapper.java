package com.op.oauth.dao.mybatis;

import com.op.oauth.bean.entity.OauthAccessToken;
import com.op.oauth.bean.entity.OauthAccessTokenExample;
import com.op.oauth.bean.entity.OauthAccessTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthAccessTokenMapper {
    int countByExample(OauthAccessTokenExample example);

    int deleteByExample(OauthAccessTokenExample example);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenExample example);

    List<OauthAccessToken> selectByExample(OauthAccessTokenExample example);

    int updateByExampleSelective(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExample(@Param("record") OauthAccessToken record, @Param("example") OauthAccessTokenExample example);
}