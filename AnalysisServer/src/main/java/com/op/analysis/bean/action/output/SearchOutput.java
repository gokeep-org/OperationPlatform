package com.op.analysis.bean.action.output;

import java.util.List;

import com.op.customer.bean.entity.Customer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class SearchOutput extends BaseOutput {
    private long total;
    private List list;
    private Customer result;
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

    public Customer getResult() {
        return result;
    }

    public void setResult(Customer result) {
        this.result = result;
    }
}
