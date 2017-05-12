package com.op.util.exception;

import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class OperationPlatformException extends RuntimeException {
    /**
     * 请求事件状态码
     */
    private String code;
    /**
     * 请求事件抛出之后生成的UUID
     * 在全局铺货异常会用到，这个UUID会跟踪整个事件的声明周期
     * 仅当只有错误发生的时候,这里是默认生成的UUID
     * 支持传入UUID串
     */
    private String uuid = UUID.randomUUID().toString();

    public OperationPlatformException(String message) {
        super(message);
    }

    public OperationPlatformException() {
    }

    public OperationPlatformException(Throwable cause) {
        super(cause);
    }

    public OperationPlatformException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public OperationPlatformException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
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
    }

    public String getUuid() {
        return uuid;
    }
}
