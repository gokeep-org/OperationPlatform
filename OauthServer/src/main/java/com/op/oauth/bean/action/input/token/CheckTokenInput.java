package com.op.oauth.bean.action.input.token;

import com.google.gson.annotations.SerializedName;
import com.op.oauth.bean.action.input.BaseInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-5
 ****************************************/
public class CheckTokenInput extends BaseInput {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("user_id")
    private String userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
