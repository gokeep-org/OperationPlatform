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
    @SerializedName("result")
    private JsonObject result;
    private String code;
    @SerializedName("msg")
    private String message;
    private Long total;

    public ReadOutput(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReadOutput(JsonObject result, String code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
