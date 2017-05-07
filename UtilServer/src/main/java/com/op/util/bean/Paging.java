package com.op.util.bean;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/4.
 ****************************************/

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * 通用分页组件
 */
public class Paging {
    //当前页码
    @SerializedName("page_now")
    private int pageNow;
    //页面大小
    @SerializedName("page_size")
    private int pageSize;
    //总记录条数
    private int total;
    //上一页
    @SerializedName("page")
    private int pageUp;
    // 下一页
    @SerializedName("page_next")
    private int pageNext;
    //页数
    @SerializedName("page_total")
    private int pageTotal;
    //排序方式
    private String order;
    // 排序字段
    private String field;
    // 分页数据
    private Map<String, Object> data;

    public Paging(int pageNow, int pageSize, int total, Map data) {
        this(pageNow, pageSize, total, data, null, null);
    }

    public Paging(int pageNow, int pageSize, int total, Map data, String field, String order) {
        this.pageNow = pageNow;
        this.total = total;
        this.data = data;
        this.pageSize = pageSize;
        this.field = (null == field) ? "id" : field;
        this.order = (null == order) ? "descend" : order;
        this.pageNext = this.pageNow + 1;
        this.pageUp = (this.pageNow == 0) ? 0 : this.pageNow - 1;
        if (this.pageSize == 0)
            this.pageTotal = 0;
        else
            this.pageTotal = ((this.total % this.pageSize) == 0) ?
                    (int) (this.total / this.pageSize) : (int) (this.total / this.pageSize) + 1;
    }

    public Paging sort(String field, String order) {
        this.field = field;
        this.order = order;
        return this;
    }

    public Paging(int pageNow, int pageSize, String field, String order){
        this(pageNow, pageSize, 0, null, field,  order);
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageUp() {
        return pageUp;
    }

    public void setPageUp(int pageUp) {
        this.pageUp = pageUp;
    }

    public int getPageNext() {
        return pageNext;
    }

    public void setPageNext(int pageNext) {
        this.pageNext = pageNext;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pageUp=" + pageUp +
                ", pageNext=" + pageNext +
                ", pageTotal=" + pageTotal +
                ", order='" + order + '\'' +
                ", field='" + field + '\'' +
                ", data=" + data +
                '}';
    }
}
