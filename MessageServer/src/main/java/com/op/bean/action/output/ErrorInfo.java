package com.op.bean.action.output;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-19
 ****************************************/
public class ErrorInfo extends BaseOutput{
    private String code;
    @SerializedName("msg")
    private String messsage;
    private UUID uuid;
    
    public ErrorInfo() {
    }
    
    public ErrorInfo(String code, String messsage, UUID uuid) {
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
    
    public UUID getUuid() {
        return uuid;
    }
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
