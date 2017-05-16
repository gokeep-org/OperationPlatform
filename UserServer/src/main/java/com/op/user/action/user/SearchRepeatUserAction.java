package com.op.user.action.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.User;
import com.op.util.bean.CommonQueryBody;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/7.
 ****************************************/
public class SearchRepeatUserAction extends ItemAction<BaseOutput> {
    private CommonQueryBody body;
    private List<User> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchRepeatUserAction.class);

    public SearchRepeatUserAction(CommonQueryBody body) {
        this.body = body;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.body) {
            throw new OperationPlatformException("body must body not is null");
        }
    }

    @Override
    protected void start() throws Exception {
        if (null == this.body.getQuery())
            this.list = null;
        else
            this.list = userService.searchUser(this.body);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        if (this.list == null)
            output.setTotal(0);
        else
            output.setTotal(this.list.size());
        output.setList(this.list);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search repeat user is successful");
    }
}
