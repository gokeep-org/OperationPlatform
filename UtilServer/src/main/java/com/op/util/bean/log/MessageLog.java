package com.op.util.bean.log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
public class MessageLog {
    /**
     * 日志消息推送对象
     */
    private String index = "log";
    private String type = "info";
    private Map<String, Object> body;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setOperLog(String message, String userId) {
        setType("oper");
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    public void setErrorLog(String message, String userId) {
        setType("error");
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", false);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    public void setLoginLog(String message, String userId) {
        setType("login");
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    public MessageLog(String type, String message, String userId) {
        setType(type);
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", false);
        setBody(body);
    }

    public MessageLog() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
