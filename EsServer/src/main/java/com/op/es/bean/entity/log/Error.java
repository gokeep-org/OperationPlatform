package com.op.es.bean.entity.log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/

/**
 * document: log
 * type: error
 */
public class Error implements Serializable {
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
