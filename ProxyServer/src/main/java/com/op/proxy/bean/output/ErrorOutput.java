package com.op.proxy.bean.output;

import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/13.
 ****************************************/
public class ErrorOutput extends BaseOutput {
    private String uuid;

    public ErrorOutput(String uuid) {
        super();
        this.uuid = uuid;
    }

    public ErrorOutput(String uuid, String code, String msg, Boolean success) {
        this.uuid = uuid;
        setCode(code);
        setMessage(msg);
        setSuccess(success);
    }

    public void setBaseOut(String code, String msg, Boolean success) {
        setCode(code);
        setMessage(msg);
        setSuccess(success);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
