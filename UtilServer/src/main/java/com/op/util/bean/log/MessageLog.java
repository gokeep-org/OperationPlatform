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
    private String type = "reuqest";
    private Map<String, Object> body;

    /**
     * 设置操作日志信息
     * @param message
     * @param userId
     */
    public void setOperLog(String message, String userId) {
        setType("oper");
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    /**
     * 设置错误日志操作信息
     * @param message
     * @param userId
     * @param uuid
     */
    public void setErrorLog(String message, String userId, String uuid) {
        setType("error");
        Map<String, Object> body = new HashMap<>();
        body.put("content", message);
        body.put("user_id", userId);
        body.put("success", false);
        body.put("date", new Date().getTime());
        body.put("uuid", uuid);
        setBody(body);
    }

    /**
     * 设置登录日志操作信息
     * @param userId
     */
    public void setLoginLog(String userId, boolean status) {
        setType("login");
        Map<String, Object> body = new HashMap<>();
        body.put("content", "user login successful");
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        if (status == false) {
            body.put("content", "user login is fail");
            body.put("success", false);
        }
        setBody(body);
    }

    /**
     * 设置分析日志信息
     * @param content
     * @param userId
     */
    public void setAnalysisLog(String content, String userId) {
        setType("analy");
        Map<String, Object> body = new HashMap<>();
        body.put("content", content);
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    /**
     * 设置请求日志信息
     * @param userId
     * @param path
     * @param method
     * @param params
     */
    public void setRequestLog(String userId, String path, String method, Map<String, Object> params) {
        setType("request");
        Map<String, Object> body = new HashMap<>();
        body.put("path", path);
        body.put("method", method);
        body.put("params", params);
        body.put("user_id", userId);
        body.put("success", true);
        body.put("date", new Date().getTime());
        setBody(body);
    }

    /**
     * 设置消息日志信息
     * @param status
     * @param userId
     */
    public MessageLog(String userId, boolean status) {
        setType("message");
        Map<String, Object> body = new HashMap<>();

        body.put("user_id", userId);
        if (status == false) {
            body.put("content", "user login is fail");
            status = false;
        } else {
            body.put("content", "user login is success");
            status = true;
        }
        setBody(body);
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
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
