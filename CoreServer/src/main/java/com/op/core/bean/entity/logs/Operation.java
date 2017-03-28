package com.op.core.bean.entity.logs;

import org.springframework.data.mongodb.core.mapping.Field;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-27
 ****************************************/
public class Operation {
    @Field("is_write")
    private String isWirte;
    @Field("is_read")
    private String isRead;

    private String isSchedu;
    private String isSyncLog;
    private String isQueue;
    private String isRedirect;
    
    public String getIsWirte() {
        return isWirte;
    }
    
    public void setIsWirte(String isWirte) {
        this.isWirte = isWirte;
    }
    
    public String getIsRead() {
        return isRead;
    }
    
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
    
    public String getIsSchedu() {
        return isSchedu;
    }
    
    public void setIsSchedu(String isSchedu) {
        this.isSchedu = isSchedu;
    }
    
    public String getIsSyncLog() {
        return isSyncLog;
    }
    
    public void setIsSyncLog(String isSyncLog) {
        this.isSyncLog = isSyncLog;
    }
    
    public String getIsQueue() {
        return isQueue;
    }
    
    public void setIsQueue(String isQueue) {
        this.isQueue = isQueue;
    }
    
    public String getIsRedirect() {
        return isRedirect;
    }
    
    public void setIsRedirect(String isRedirect) {
        this.isRedirect = isRedirect;
    }
}
