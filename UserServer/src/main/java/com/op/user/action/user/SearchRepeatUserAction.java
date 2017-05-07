package com.op.user.action.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/7.
 ****************************************/
public class SearchRepeatUserAction extends ItemAction<BaseOutput> {
    private String username;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchRepeatUserAction.class);
    public SearchRepeatUserAction(String username) {
        this.username = username;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.username){
            throw new OperationPlatformException("search repeat user by username must username not is null");
        }
    }

    @Override
    protected void start() throws Exception {
//        userService.searchUserByUserId()
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return null;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
