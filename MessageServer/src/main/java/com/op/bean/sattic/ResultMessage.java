package com.op.bean.sattic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/

/**
 * rest结果信息
 */
public class ResultMessage implements Serializable{
    private String code;
    private String messsage;
    private Boolean success;
    private UUID uuid;

    public ResultMessage(String code, String messsage, Boolean success, UUID uuid) {
        this.code = code;
        this.messsage = messsage;
        this.success = success;
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
