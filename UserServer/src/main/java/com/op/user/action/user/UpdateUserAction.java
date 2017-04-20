package com.op.user.action.user;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class UpdateUserAction extends ItemAction<BaseOutput> {
    private String userId;
    private User user;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserAction.class);
    public UpdateUserAction(String userId, User user) {
        this.userId = userId;
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
        if (Objects.equals(null, this.user)){
            //为空不做任何操
        }else{
            this.user.setId(this.userId);
            userService.updateUserByUserId(user);
        }

    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return new ResultMessage();
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("update user is successful");
    }
}
