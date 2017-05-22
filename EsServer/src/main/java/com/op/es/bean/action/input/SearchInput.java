package com.op.es.bean.action.input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/21.
 ****************************************/
public class SearchInput {
    private long from;
    private long size;
    private Map<String, Object> sort;
    private Map<String, Object> query;

    public SearchInput() {

    }
    public SearchInput setPaging(long form, long size, String field, String order) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("order", order);
        map.put(field, orderMap);
        this.from = form;
        this.size = size;
        this.sort = map;
        return this;
    }

    public SearchInput setFilter(List filterMatch){
        return this;
    }

    public SearchInput setMustAndFilter(String clauses, List mustMatch, List filterMatch) {
        Map<String, Object> map = new HashMap<>();
        map.put("must", mustMatch);
        map.put("filter", filterMatch);
        this.query.put(clauses, map);
        return this;
    }



    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Map<String, Object> getSort() {
        return sort;
    }

    public void setSort(Map<String, Object> sort) {
        this.sort = sort;
    }

    public Map<String, Object> getQuery() {
        return query;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }
}
