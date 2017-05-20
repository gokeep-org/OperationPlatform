package com.op.user.action.user;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.LogMessage;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/16.
 ****************************************/
public class UpdateUserTeamAction extends ItemAction<ResultMessage> {
    private String userId;
    private String teamId;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserTeamAction.class);

    public UpdateUserTeamAction(String userId, String teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.userId || null == this.teamId)
            throw new OperationPlatformException("team id must is not null");
        if (Objects.equals(null, teamService.searchTeamByTeamId(this.teamId)))
            throw new OperationPlatformException("team id is not exist");
    }

    @Override
    protected void start() throws Exception {
        userService.updateUserTeam(this.userId, this.teamId);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("update user team is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.UPDATE_USER_TEAM_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.UPDATE_USER_TEAM_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
