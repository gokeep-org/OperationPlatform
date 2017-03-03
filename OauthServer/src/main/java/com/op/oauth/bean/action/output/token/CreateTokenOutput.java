package com.op.oauth.bean.action.output.token;

import com.google.gson.annotations.SerializedName;
import com.op.oauth.bean.action.output.ResultOutput;
import com.op.oauth.bean.entity.Token;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class CreateTokenOutput extends ResultOutput {
    @SerializedName("token_info")
    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
