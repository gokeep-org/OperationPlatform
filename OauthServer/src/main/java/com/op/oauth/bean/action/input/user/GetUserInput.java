package com.op.oauth.bean.action.input.user;

import com.google.gson.annotations.SerializedName;
import com.op.oauth.bean.action.input.BaseInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public class GetUserInput extends BaseInput {
    @SerializedName("user_id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
