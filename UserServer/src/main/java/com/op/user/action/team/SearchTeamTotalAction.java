package com.op.user.action.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.SearchOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class SearchTeamTotalAction extends ItemAction<SearchOutput> {
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchTeamTotalAction.class);

    public SearchTeamTotalAction() {
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        this.total = teamService.searchTeamTotal();
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search team total is successful");
    }
}
