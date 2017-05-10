package com.op.oauth.bean.action.output.common;

import java.util.List;

import com.google.gson.JsonObject;
import com.op.oauth.bean.action.output.item.ItemOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/10.
 ****************************************/
public class SearchOutput extends ItemOutput{
    private JsonObject result;
    private List list;

    public JsonObject getResult() {
        return result;
    }

    public void setResult(JsonObject result) {
        this.result = result;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
