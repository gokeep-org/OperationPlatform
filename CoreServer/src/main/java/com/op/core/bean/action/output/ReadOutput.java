package com.op.core.bean.action.output;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class ReadOutput extends BaseOutput {
    @SerializedName("res")
    private JsonObject result;
    private String code;
    @SerializedName("msg")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject getResult() {
        return result;
    }

    public void setResult(JsonObject result) {
        this.result = result;
    }
}
