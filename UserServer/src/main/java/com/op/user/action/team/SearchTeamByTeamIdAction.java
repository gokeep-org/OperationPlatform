package com.op.user.action.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.Team;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class SearchTeamByTeamIdAction extends ItemAction<SearchOutput> {
    private String teamId;
    private Team team;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchTeamByTeamIdAction.class);

    public SearchTeamByTeamIdAction(String teamId) {
        this.teamId = teamId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.teamId)
            throw new OperationPlatformException("search team by id must id is not null");
    }

    @Override
    protected void start() throws Exception {
        this.team = teamService.searchTeamByTeamId(this.teamId);
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setResult(this.team);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search team is successful");
    }
}