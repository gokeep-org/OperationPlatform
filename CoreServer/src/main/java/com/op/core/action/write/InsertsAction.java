package com.op.core.action.write;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.InsertInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.WriteOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/18.
 ****************************************/
public class InsertsAction extends ItemAction<BaseOutput> {
    private String collectionName;
    private List<Object> os;
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertsAction.class);

    public InsertsAction(InsertInput input) {
        this.collectionName = input.getCollectionName();
        this.os = (List<Object>) input.getO();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        writeService.inserts(this.os, collectionName);
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
        LOGGER.info("batch add obj is successful");
    }
}
