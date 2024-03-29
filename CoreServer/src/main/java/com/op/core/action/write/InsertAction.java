package com.op.core.action.write;

import java.util.Map;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.InsertInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.WriteOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class InsertAction extends ItemAction<BaseOutput> {
    private String collectionName;
    private Map<String, Object> body;

    public InsertAction(InsertInput input) {
        this.body = (Map<String, Object>) input.getO();
        this.collectionName = input.getCollectionName();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        writeService.insert(this.body, collectionName);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        WriteOutput output = new WriteOutput();
        output.setCode("200");
        output.setMessage("操作成功");
        output.setSuccess(true);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
