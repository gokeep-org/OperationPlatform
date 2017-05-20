package com.op.customer.bean.action.output;

import java.util.UUID;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-19
 ****************************************/
public class ErrorInfoOutput extends BaseOutput {
    private String code;
    @SerializedName("msg")
    private String messsage;
    private UUID uuid;

    public ErrorInfoOutput() {
    }

    public ErrorInfoOutput(String code, String messsage) {
        this.code = code;
        this.messsage = messsage;
        this.uuid = UUID.randomUUID();
        setSuccess("false");
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
