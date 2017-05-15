package com.op.message.action.mq;

import com.op.message.action.item.ItemAction;
import com.op.message.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class PushMessageToMongoAction extends ItemAction<BaseOutput> {
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
