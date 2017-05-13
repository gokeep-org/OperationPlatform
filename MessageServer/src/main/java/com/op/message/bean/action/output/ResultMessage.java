package com.op.message.bean.action.output;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

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
    @Value("200")
    private String code;
    @Value("操作成功")
    private String messsage;
    private UUID uuid;

    public ResultMessage() {

    }

    public ResultMessage(String code, String messsage, Boolean success, UUID uuid) {
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


    public void setSuccess(String success) {
        super.setSuccess(success);
        if (success.equals(false)) {
            setUuid(UUID.randomUUID());
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
