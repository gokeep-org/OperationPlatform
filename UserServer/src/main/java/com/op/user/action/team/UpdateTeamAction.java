package com.op.user.action.team;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.entity.user.Team;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class UpdateTeamAction extends ItemAction<ResultMessage> {
    private String teamId;
    private Team team;

    public UpdateTeamAction(String teamId, Team team) {
        this.teamId = teamId;
        this.team = team;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.teamId || null == this.team)
            throw new OperationPlatformException("update team must team id and body is not null");
    }

    @Override
    protected void start() throws Exception {
        teamService.updateTeam(this.teamId, this.team);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setMesssage("update team is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
