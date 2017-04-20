package com.op.user.action.output;

import java.util.UUID;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/

/**
 * rest结果信息
 */
public class ResultMessage extends BaseOutput {
    private String code;
    @SerializedName("msg")
    private String messsage;
    private UUID uuid;

    public ResultMessage() {
        super();
        this.code = "200";
        this.messsage = "操作成功";
        super.setSuccess("true");
    }

    public void setUUID(String uuid) {
        this.code = "500";
        this.messsage = "操作失败";
        this.setSuccess(false);
    }

    public ResultMessage(String code, String messsage, String success, UUID uuid) {
        this.code = code;
        this.messsage = messsage;
        setSuccess(success);
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
        this.setSuccess(success);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
