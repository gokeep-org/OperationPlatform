package com.op.user.action.output;

import java.util.List;

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
    private Object result;
    private List list;
    @SerializedName("page_now")
    private long pageNow;
    @SerializedName("page_size")
    private long pageSize;
    @SerializedName("current_total")
    private long currentTotal;
    public void setTotal(long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public long getPageNow() {
        return pageNow;
    }

    public void setPageNow(long pageNow) {
        this.pageNow = pageNow;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(long currentTotal) {
        this.currentTotal = currentTotal;
    }
}
