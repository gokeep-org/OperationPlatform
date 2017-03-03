package com.op.oauth.bean.action.output;

import java.util.UUID;

import com.google.gson.annotations.SerializedName;
import com.op.oauth.bean.action.output.item.ItemOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/

/**
 * rest结果信息
 */
public class ResultOutput extends ItemOutput {
    private String code = "200";
    @SerializedName("msg")
    private String messsage = "操作成功";
    private String uuid = null;

    public ResultOutput() {
        super();
    }

    public ResultOutput(String code, String messsage, Boolean success, String uuid) {
        this.code = code;
        this.messsage = messsage;
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


    public void setSuccess(Boolean success) {
        this.success = success.toString();
        if (success.equals(false)) {
            setUuid(UUID.randomUUID().toString());
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}