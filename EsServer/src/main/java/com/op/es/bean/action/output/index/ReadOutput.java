package com.op.es.bean.action.output.index;

import java.io.Serializable;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.op.es.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
public class ReadOutput extends BaseOutput implements Serializable {
    @SerializedName("result")
    private Map<String, Object> result;

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
