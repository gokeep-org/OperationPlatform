package com.op.core.bean.entity.auth;

import org.springframework.data.mongodb.core.mapping.Field;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-27
 ****************************************/
public class OauthToken {
    private String id;
    @Field("token_id")
    private String tokenId;
    @Field("access_token")
    private String accessToken;
    @Field("refresh_token")
    private String refreshToken;
    @Field("exprise_in")
    private Long expriseIn;
    @Field("client_id")
    private String clientId;
    @Field("user_id")
    private String userId;
    @Field("create_date")
    private Long createDate;
    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpriseIn() {
        return expriseIn;
    }

    public void setExpriseIn(Long expriseIn) {
        this.expriseIn = expriseIn;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
