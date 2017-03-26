package com.op.core.bean.entity.auth;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-27
 ****************************************/
public class OauthUser {
    private String id;
    private String userId;
    private String password;
    private Boolean status;
    private Long createDate;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public Long getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}