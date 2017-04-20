package com.op.user.action.output;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class SearchOutput extends ResultMessage {
    private Long total;
    @SerializedName("result")
    private Map<String, Object> result;

    public Map<String, Object> getResult() {
        return result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
