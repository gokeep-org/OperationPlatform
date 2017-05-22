package com.op.oauth.action.auth;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.common.SearchOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/21.
 ****************************************/
public class SearchEventListAction extends ItemAction<BaseOutput> {
    private List list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchEventListAction.class);

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        this.list = authService.getEventList();
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setList(this.list);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search event list is successful");
    }
}
