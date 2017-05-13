package com.op.message.bean.entity.es;

import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/

/**
 * Es索引统一设置
 * index： 索引名称
 * type: 索引类型
 * body: 索引内容
 */
public class EsEntity {
    private String index;
    private String type;
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
