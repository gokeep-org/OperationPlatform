package com.op.oauth.bean.entity;


import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/9.
 ****************************************/
public class Rule {
    /**
     * 用户调用接口规则定义Bean
     * request->events关键参数
     * id: 唯一标识
     * name： 角色名称
     * sattus：规则状态
     * 设立使用的的每一条记录使用的增量添加的方式，evnets通过可视化管理界面动态添加
     * 权限。为权限控制最低单位。角色作为最底层进行简单定义
     */
    @SerializedName("_id")
    private String id;
    private String name;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
