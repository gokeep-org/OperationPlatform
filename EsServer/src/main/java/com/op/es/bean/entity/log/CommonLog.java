//package com.op.es.bean.entity.log;
//
//import org.springframework.data.elasticsearch.annotations.Document;
//
//import com.google.gson.annotations.SerializedName;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/31.
// ****************************************/
//@Document(indexName = "log", type = "common")
//public class CommonLog {
//    private String id;
//    @SerializedName("login_id")
//    private String logId;
//    @SerializedName("user_id")
//    private String userId;
//    private String username;
//    private String content;
//    private Request request;
//    private String remark;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getLogId() {
//        return logId;
//    }
//
//    public void setLogId(String logId) {
//        this.logId = logId;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Request getRequest() {
//        return request;
//    }
//
//    public void setRequest(Request request) {
//        this.request = request;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
//}
