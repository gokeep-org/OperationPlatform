package com.op.analysis.bean.action.output;

import java.util.List;
import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class SearchOutput extends BaseOutput {
    private long total;
    private List list;
    private Map result;

    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }

    public SearchOutput(Map result) {
        this.result = result;
    }

    public SearchOutput() {
    }

    public SearchOutput(long total, List list, Map result) {
        this.total = total;
        this.list = list;
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
