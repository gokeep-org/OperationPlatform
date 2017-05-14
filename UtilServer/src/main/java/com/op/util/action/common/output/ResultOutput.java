package com.op.util.action.common.output;

import java.util.List;
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
public class ResultOutput extends BaseOutput {
    private String code = "200";
    private String messsage = "操作成功";
    private String uuid;
    private long total;
    private List result;

    public ResultOutput() {

    }

    public ResultOutput(List result) {
        this.result = result;
    }

    public ResultOutput(long total) {
        this.total = total;
    }

    public ResultOutput(String code, String messsage, Boolean success, String uuid) {
        this.code = code;
        this.messsage = messsage;
        this.uuid = uuid;
    }

    public void isFail() {
        this.setCode("500");
        this.setSuccess(false);
        this.setMesssage("操作失败");
        this.setUuid(UUID.randomUUID().toString());
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}

