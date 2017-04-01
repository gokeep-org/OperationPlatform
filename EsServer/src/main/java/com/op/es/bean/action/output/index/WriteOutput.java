package com.op.es.bean.action.output.index;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import com.op.es.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
public class WriteOutput extends BaseOutput implements Serializable {
    public WriteOutput(int code, String message, String uuid) {
        this.code = code;
        this.message = message;
        this.uuid = uuid;
    }

    public WriteOutput(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public WriteOutput() {
    }

    private int code;
    @SerializedName("msg")
    private String message;
    private String uuid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
