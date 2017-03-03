package com.op.oauth.bean.action.input.token;

import com.google.gson.annotations.SerializedName;
import com.op.oauth.bean.action.input.BaseInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class CreateTokenInput extends BaseInput{
    @SerializedName("grant_type")
    private String grantType;
    @SerializedName("redirect_uri")
    private String redirectUri;
    @SerializedName("refresh_token")
    private String refreshToke;
    @SerializedName("user_name")
    private String userName;
    private String password;
    private String code;
    private String authorization;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getRefreshToke() {
        return refreshToke;
    }

    public void setRefreshToke(String refreshToke) {
        this.refreshToke = refreshToke;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
