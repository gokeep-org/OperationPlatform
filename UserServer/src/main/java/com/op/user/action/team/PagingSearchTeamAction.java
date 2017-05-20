package com.op.user.action.team;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.input.user.SearchInput;
import com.op.user.action.item.ItemAction;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.LogMessage;
import com.op.util.bean.Paging;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class PagingSearchTeamAction extends ItemAction<SearchOutput> {
    private SearchInput input;
    private Paging paging;
    private List list;
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(PagingSearchTeamAction.class);

    public PagingSearchTeamAction(SearchInput input, Paging paging) {
        this.input = input;
        this.paging = paging;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.paging))
            throw new OperationPlatformException("paging search team paging obj is must is not null");
    }

    @Override
    protected void start() throws Exception {
        this.list = teamService.searchTeamListByPaging(this.input, this.paging);
        this.total = teamService.searchTeamTotal();
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        output.setList(this.list);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_TEAM_SECCUSS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_TEAM_SECCUSS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
