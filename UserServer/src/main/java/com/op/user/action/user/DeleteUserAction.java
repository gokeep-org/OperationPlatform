package com.op.user.action.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.LogMessage;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class DeleteUserAction extends ItemAction<BaseOutput> {
    private String userId;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteUserAction.class);
    public DeleteUserAction(String userId) {
        this.userId = userId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.userId){
            throw  new OperationPlatformException("user id is null");

        }
    }

    @Override
    protected void start() throws Exception {
        userService.deleteUserByUserId(userId);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return new ResultMessage();
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.DELETE_USER_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.DELETE_USER_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
