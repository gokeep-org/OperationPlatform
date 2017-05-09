package com.op.oauth.bean.entity;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/9.
 ****************************************/
public class Event {
    /**
     * 用户请求事件Bean
     * 参数定义：
     * id：event唯一标识
     * name：事件名称
     * path：请求路径
     * method：请求方法
     * status：event定义状态，true为可用状态，false为不可用状态
     * 注： 这是用户请求事件的定义最基本定义，上一层定义为Rule
     */
    private String id;
    private String name;
    private String path;
    private String method;
    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
