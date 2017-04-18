package com.op.proxy.config;

import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class OperationPlatformException extends RuntimeException {
    private String code;
    private String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

    public OperationPlatformException() {
    }

    public OperationPlatformException(Throwable cause) {
        super(cause);
    }

    public OperationPlatformException(String message) {
        super(message);
    }

    public OperationPlatformException(String message, String code, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public OperationPlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid;
        this.getMessage();
    }
}
