package com.op.user.action.team;

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
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class DeleteTeamAction extends ItemAction<ResultMessage> {
    private String teamId;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteTeamAction.class);

    public DeleteTeamAction(String teamId) {
        this.teamId = teamId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.teamId)
            throw new OperationPlatformException("delete team by id must is is not null");
    }

    @Override
    protected void start() throws Exception {
        teamService.deleteTeamByTeamId(this.teamId);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("delete team is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.DELETE_TEAM_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.DELETE_TEAM_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
