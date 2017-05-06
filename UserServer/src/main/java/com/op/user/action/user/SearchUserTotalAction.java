package com.op.user.action.user;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/6.
 ****************************************/
public class SearchUserTotalAction extends ItemAction<BaseOutput> {
    private User user;
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchUserTotalAction.class);

    public SearchUserTotalAction(User user) {
        this.user = user;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {

    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        if (Objects.equals(null, this.user))
            this.total = userService.size();
        else
            this.total = userService.size(this.user);
        SearchOutput output = new SearchOutput();
        output.setTotal(this.total);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("get user total is successful");
    }
}
