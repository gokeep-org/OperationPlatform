package com.op.user.action.team;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.LogMessage;
import com.op.user.bean.entity.user.Team;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class CreateTeamAction extends ItemAction<ResultMessage> {
    private Team team;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTeamAction.class);

    public CreateTeamAction(Team team) {
        this.team = team;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.team))
            throw new OperationPlatformException("create team must body is not null");
        String commonTeamId = UUID.randomUUID().toString();
        this.team.setId(commonTeamId);
        this.team.setTeamId(commonTeamId);
        this.team.setStatus((null == this.team.getStatus()) ? true : this.team.getStatus());
        this.team.setActivated((null == this.team.getActivated()) ? true : this.team.getActivated());
        this.team.setCreateTime(new Date().getTime());
    }

    @Override
    protected void start() throws Exception {
        teamService.createTeam(team);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("create team is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.CREATE_TEAM_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.CREATE_TEAM_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
