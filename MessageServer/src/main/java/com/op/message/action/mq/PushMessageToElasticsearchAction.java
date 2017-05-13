package com.op.message.action.mq;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.message.action.item.ItemAction;
import com.op.message.bean.action.output.BaseOutput;
import com.op.message.bean.action.output.ResultMessage;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
public class PushMessageToElasticsearchAction extends ItemAction<BaseOutput> {
    private Map<String, Object> message;
    private static final Logger LOGGER = LoggerFactory.getLogger(PushMessageToElasticsearchAction.class);

    public PushMessageToElasticsearchAction(Map<String, Object> message) {
        this.message = message;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        try {
            mqService.pushToElasticsearch(this.message);
        }catch (Throwable e){
            LOGGER.error("push message to elasticsearch in action is fail");
        }

    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setMesssage("push message is successful");
        resultMessage.setSuccess("true");
        resultMessage.setCode("200");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("push message to elasticsearch is successful");
    }
}
