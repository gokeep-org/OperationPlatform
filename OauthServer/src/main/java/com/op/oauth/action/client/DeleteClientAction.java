package com.op.oauth.action.client;

import java.util.List;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.client.DeleteClientInput;
import com.op.oauth.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class DeleteClientAction extends ItemAction<BaseOutput> {
    private List<String> clientIds;
    public DeleteClientAction(DeleteClientInput input) {
        this.clientIds = input.getClientIds();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {

    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return null;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
