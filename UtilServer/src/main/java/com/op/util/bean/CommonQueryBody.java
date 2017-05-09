package com.op.util.bean;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/9.
 ****************************************/
public class CommonQueryBody {
    /***
     * 通用查询body
     * index： 索引名称，比如ES
     * collectionName: 集合类型，ES的type和mongo的colleciton
     * query： 过滤条件
     */
    private String index;
    @SerializedName("type")
    private String collectionName;
    private String id;
    private Map<String, Object> query;

    public Map<String, Object> getQuery() {
        return query;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }


    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
